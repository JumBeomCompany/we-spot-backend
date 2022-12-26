package com.example.wespotbackend.feed;

import com.example.wespotbackend.feed.dto.FeedResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepositoryCustom {

    List<FeedResponse> paginationNoOffset(Long lastFeedId, int pageSize);
}