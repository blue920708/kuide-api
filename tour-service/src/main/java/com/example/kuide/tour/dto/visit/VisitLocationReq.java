package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class VisitLocationReq extends VisitCommonReq {

    @Schema(description = "정렬 구분", defaultValue = "C")
    private String arrange;

    @Schema(description = "GPS X 좌표(경도)", defaultValue = "126.98375")
    private Double mapX;

    @Schema(description = "GPS Y 좌표(위도)", defaultValue = "37.563446")
    private Double mapY;

    @Schema(description = "거리 반경(m)", defaultValue = "1000")
    private Integer radius;

    @Schema(description = "콘텐츠 타입 ID", defaultValue = "39")
    private Integer contentTypeId;

    @JsonProperty("lDongRegnCd")
    @Schema(description = "법정동 시도 코드", defaultValue = "11")
    private String lDongRegnCd;

    @JsonProperty("lDongSignguCd")
    @Schema(description = "법정동 시군구 코드", defaultValue = "140")
    private String lDongSignguCd;

    @Schema(description = "대분류 코드", defaultValue = "FD")
    private String lclsSystm1;

    @Schema(description = "중분류 코드", defaultValue = "FD01")
    private String lclsSystm2;

    @Schema(description = "소분류 코드", defaultValue = "FD010100")
    private String lclsSystm3;
}
