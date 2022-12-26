package com.example.wespotbackend.feed;

import com.example.wespotbackend.feed.dto.FeedResponse;
import com.example.wespotbackend.user.User;
import com.example.wespotbackend.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {
    private final FeedRepositoryCustom feedRepositoryCustom;

    @Autowired
    public FeedService(@Qualifier("feedRepositoryCustomImpl") FeedRepositoryCustom feedRepositoryCustom) {
        this.feedRepositoryCustom = feedRepositoryCustom;
    }

    public List<FeedResponse> getFeedsPageBy(Long lastFeedId, int size) {
        List<FeedResponse> paginationFeedList = feedRepositoryCustom.paginationNoOffset(lastFeedId, size);
        return addUserResponseToFeedResponseList(paginationFeedList);
    }

    private List<FeedResponse> addUserResponseToFeedResponseList(List<FeedResponse> feedResponseList) {
        return feedResponseList.stream().peek(feedResponse -> {
            User user = feedResponse.getUser();
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .build();
            feedResponse.setUserResponse(userResponse);
        }).collect(Collectors.toList());
    }
}
