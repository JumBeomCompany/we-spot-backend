package com.example.wespotbackend.marker.api;

import com.example.wespotbackend.common.dto.ApiResult;
import com.example.wespotbackend.marker.MarkerService;
import com.example.wespotbackend.marker.dto.MarkerRequest;
import com.example.wespotbackend.marker.dto.MarkerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
