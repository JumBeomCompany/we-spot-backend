package com.example.wespotbackend.marker;

import com.example.wespotbackend.common.exception.NotExistsFeedException;
import com.example.wespotbackend.common.exception.NotExistsMarkerException;
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

import javax.xml.crypto.MarshalException;
import java.util.List;
import java.util.stream.Collectors;

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

        return buildMarkerResponse(savedMarker);
    }

    @Transactional
    public Boolean update(Long markerId, MarkerRequest markerRequest) {
        // 1. 사용자 조회
        User findUser = userRepository.findById(markerRequest.getUserId()).orElseThrow(NotExistsUserException::new);

        // 2. 피드 정보 조회 및 수정
        Marker findMarker = markerRepository.findById(markerId).orElseThrow(NotExistsMarkerException::new);
        Feed findFeed = findMarker.getFeed();

        Feed modifiedFeed = Feed.builder()
                        .user(findUser)
                        .title(markerRequest.getFeedTitle())
                        .content(markerRequest.getFeedContent())
                        .build();
        findFeed.updateFeed(modifiedFeed);

        return Boolean.TRUE;
    }

    @Transactional(readOnly = true)
    public List<MarkerResponse> getMarkers(Long userId) {
        // 사용자가 등록한 마커들 조회
        List<Marker> markers = markerRepository.findByUserId(userId);

        return markers.stream()
                .map(this::buildMarkerResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MarkerResponse getMarker(Long markerId) {
        Marker findMarker = markerRepository.findById(markerId).orElseThrow(NotExistsMarkerException::new);

        return buildMarkerResponse(findMarker);
    }

    /**
     * Build for MarkerResponse DTO
     * @param marker Marker Entity
     * @return MarkerResponse DTO
     */
    private MarkerResponse buildMarkerResponse(Marker marker) {
        return MarkerResponse.builder()
                .id(marker.getId())
                .latitude(marker.getMakerLocation().getLatitude())
                .longitude(marker.getMakerLocation().getLongitude())
                .feedTitle(marker.getFeed().getTitle())
                .feedContent(marker.getFeed().getContent())
                .build();
    }
}
