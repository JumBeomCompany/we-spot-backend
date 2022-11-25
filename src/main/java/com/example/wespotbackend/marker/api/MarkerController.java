package com.example.wespotbackend.marker.api;

import com.example.wespotbackend.common.dto.ApiResult;
import com.example.wespotbackend.marker.MarkerService;
import com.example.wespotbackend.marker.dto.MarkerRequest;
import com.example.wespotbackend.marker.dto.MarkerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.wespotbackend.common.dto.ApiResult.succeed;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class MarkerController {
    private final MarkerService markerService;

    /**
     * 마커와 피드 등록
     *
     * @param request MarkerRequest DTO
     * @return MarkerResponse DTO
     */
    @PostMapping("/marker")
    public ApiResult<MarkerResponse> registerMarker(@RequestBody MarkerRequest request) {
        final MarkerResponse savedMarkerResponse = markerService.save(request);
        return succeed(savedMarkerResponse);
    }

    /**
     * 마커 정보 수정 (피드)
     * @param request MarkerRequest DTO
     * @return MarkerResponse DTO
     */
    @PatchMapping("/marker/{markerId}")
    public ApiResult<Boolean> modifyMarker(@PathVariable Long markerId, @RequestBody MarkerRequest request) {
        final Boolean modifiedMarkerResponse = markerService.update(markerId, request);
        return succeed(modifiedMarkerResponse);
    }


    /**
     * 사용자별 마커 조회
     * @param userId 사용자 고유 id
     * @return MarkerResponse DTO List
     */
    @GetMapping("/markers")
    public ApiResult<List<MarkerResponse>> getMarkers(@RequestParam Long userId) {
        final List<MarkerResponse> markerResponses = markerService.getMarkers(userId);
        return succeed(markerResponses);
    }

    /**
     * 마커 단건 조회
     * @param markerId 마커 고유 id
     * @return MarkerResponse DTO
     */
    @GetMapping("/markers/{markerId}")
    public ApiResult<MarkerResponse> getMarker(@PathVariable Long markerId) {
        final MarkerResponse markerResponse = markerService.getMarker(markerId);
        return succeed(markerResponse);
    }
}
