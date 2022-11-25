package com.example.wespotbackend.marker.api;

import com.example.wespotbackend.common.exception.RestControllerExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("마커 API 통합 테스트")
@SpringBootTest
class MarkerControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private MarkerController markerController;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(markerController)
                .setControllerAdvice(new RestControllerExceptionHandler())
                .build();
    }

//    void 마커_리스트_조회_성공_테스트() {
//        ResultActions result = mockMvc.perform(
//            get("/api/v1/marker")
//        )
//    }
}