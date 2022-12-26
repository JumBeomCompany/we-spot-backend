package com.example.wespotbackend.marker;

import com.example.wespotbackend.feed.Feed;
import com.example.wespotbackend.feed.FeedRepository;
import com.example.wespotbackend.user.User;
import com.example.wespotbackend.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MarkerRepositoryTest {
    @Autowired
    private MarkerRepository markerRepository;

    @Autowired
    private FeedRepository FeedRepository;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private Feed feed;

    @BeforeEach
    public void init() {
        user = User.builder()
                .email("tester@naver.com")
                .name("tester")
                .password("[SECRET]")
                .build();
        User getUser = userRepository.save(user);

        feed = Feed.builder()
                .user(getUser)
                .title("title")
                .build();
        FeedRepository.save(feed);
    }

    @Test
    public void MarkerRepository가Null이아님() {
        assertThat(markerRepository).isNotNull();
    }

    @Test
    public void 마커_저장하기_성공테스트() {
        // given
        Marker marker = Marker.builder()
                .feed(feed)
                .user(user)
                .makerLocation(MarkerLocation.of(1.1, 1.1))
                .build();

        // when
        Marker result = markerRepository.save(marker);

        // then
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    public void 마커_조회_성공테스트() {
        // given
        마커_저장하기_성공테스트();

        // when
        Marker findMarker = markerRepository.findByMakerLocation(MarkerLocation.of(1.1, 1.1)).orElseThrow();

        // then
        assertThat(findMarker).isNotNull();
    }

    @Test
    public void 마커_조회_성공테스트_사용자가_찍은마크_조회()
    {
        // given
        마커_저장하기_성공테스트();

        // when
        List<Marker> findMarkers = markerRepository.findByUserId(user.getId());

        // then
        assertThat(findMarkers.size()).isGreaterThan(0);
    }
}