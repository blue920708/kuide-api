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
public class VisitKeywordReq extends VisitCommonReq {

    private String keyword;

    @Schema(defaultValue = "Q")
    private String arrange;

    private String contentTypeId;

    @JsonProperty("lDongRegnCd")
    private String lDongRegnCd;

    @JsonProperty("lDongSignguCd")
    private String lDongSignguCd;

    private String lclsSystm1;
    private String lclsSystm2;
    private String lclsSystm3;
}
