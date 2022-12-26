package com.example.wespotbackend.marker;

import com.example.wespotbackend.feed.Feed;
import com.example.wespotbackend.feed.FeedRepository;
import com.example.wespotbackend.marker.dto.MarkerRequest;
import com.example.wespotbackend.marker.dto.MarkerResponse;
import com.example.wespotbackend.user.User;
import com.example.wespotbackend.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MarkerServiceTest {
    @Autowired
    private MarkerService markerService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository FeedRepository;

    private User user;
    private Feed feed;

    @BeforeEach
    public void init() {
        user = User.builder()
                .id(1L)
                .email("tester@naver.com")
                .name("tester")
                .password("[SECRET]")
                .build();
        User getUser = userRepository.save(user);
    }

    @Test
    public void 마커_등록하기_성공테스트() {
        // given
        MarkerRequest markerRequest = MarkerRequest.builder()
                .latitude(1.1)
                .longitude(1.1)
                .userId(1L)
                .feedTitle("feed title!")
                .build(); //dto

        // when
        MarkerResponse markerResponse = markerService.save(markerRequest);

        // then
        assertThat(markerResponse).isNotNull();
    }
}
