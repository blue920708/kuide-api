package com.example.kuide.tour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kuide.tour.common.ApiResult;
import com.example.kuide.tour.common.CommonCode;
import com.example.kuide.tour.dto.visit.VisitLclsSystmReq;
import com.example.kuide.tour.dto.visit.VisitLdongReq;
import com.example.kuide.tour.service.VisitService;
import com.example.kuide.tour.dto.visit.VisitAreaReq;
import com.example.kuide.tour.dto.visit.VisitLocationReq;
import com.example.kuide.tour.dto.visit.VisitKeywordReq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import com.example.kuide.tour.dto.visit.VisitDetailReq;

@RestController
@RequestMapping("/api/v1/visit")
@Tag(name = "Visit", description = "관광지 조회 API")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/health")
    public ApiResult<?> health() {
        return new ApiResult<>(CommonCode.SUCCESS.SUCCESS);
    }

    @GetMapping("/ldong")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getLdong(@ModelAttribute VisitLdongReq request) {
        return visitService.getLdong(request);
    }

    @GetMapping ("/lclsSystm")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getLclsSystm(@ModelAttribute VisitLclsSystmReq request) {
        return visitService.getLclsSystmRes(request);
    }

    @GetMapping("/area")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getVisitArea(@ModelAttribute VisitAreaReq request) {
        return visitService.getVisitArea(request);
    }

    @GetMapping("/keyword")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getVisitKeyword(@ModelAttribute VisitKeywordReq request) {
        return visitService.getVisitKeyword(request);
    }

    @GetMapping("/location")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getVisitLocation(@ModelAttribute VisitLocationReq request) {
        return visitService.getVisitLocation(request);
    }

    @GetMapping("/detail")
    @Operation(
        responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ApiResult.class)))}
    )
    public ApiResult<?> getVisitDetail(@ModelAttribute VisitDetailReq request) {
        return visitService.getVisitDetail(request);
    }

}