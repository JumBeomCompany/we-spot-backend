package com.example.wespotbackend.feed.api;

import com.example.wespotbackend.common.dto.ApiResult;
import com.example.wespotbackend.feed.FeedService;
import com.example.wespotbackend.feed.dto.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.wespotbackend.common.dto.ApiResult.succeed;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class FeedController {
    private final FeedService feedService;

    /**
     * 피드 페이지 네이션 (no-offset)
     * @param lastFeedId 마지막 피드 아이디
     * @param size 페이징 크기
     * @return Feed DTO List
     */
    @GetMapping("/feeds")
    public ApiResult<List<FeedResponse>> getFeeds(@RequestParam Long lastFeedId, @RequestParam int size) {
        final List<FeedResponse> feedResponseList = feedService.getFeedsPageBy(lastFeedId, size);
        return succeed(feedResponseList);
    }
}
