package com.example.wespotbackend.marker;

import com.example.wespotbackend.common.exception.NotExistsUserException;
import com.example.wespotbackend.feed.Feed;
import com.example.wespotbackend.feed.FeedRepository;
import com.example.wespotbackend.marker.dto.MarkerRequest;
import com.example.wespotbackend.marker.dto.MarkerResponse;
import com.example.wespotbackend.user.User;
import com.example.wespotbackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MarkerService {
    private final MarkerRepository markerRepository;
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional
    public MarkerResponse save(MarkerRequest markerRequest) {
        // 1. 사용자 조회
        User findUser = userRepository.findById(markerRequest.getUserId()).orElseThrow(NotExistsUserException::new);

        // 2. 피드 저장
        Feed newFeed = Feed.builder()
                .user(findUser)
                .title(markerRequest.getFeedTitle())
                .content(markerRequest.getFeedContent())
                .build();
        Feed savedFeed = feedRepository.save(newFeed);

        // 3. 마커 저장
        Marker newMarker = Marker.builder()
                .feed(savedFeed)
                .user(findUser)
                .makerLocation(MarkerLocation.of(markerRequest.getLatitude(), markerRequest.getLongitude()))
                .build();

        Marker savedMarker = markerRepository.save(newMarker);

        return MarkerResponse.builder()
                .id(savedMarker.getId())
                .build();
    }
}
