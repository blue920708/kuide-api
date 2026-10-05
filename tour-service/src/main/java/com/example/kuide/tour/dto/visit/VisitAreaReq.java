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
public class VisitAreaReq extends VisitCommonReq {


    @Schema(defaultValue = "A")
    private String arrange;

    @Schema(defaultValue = "14")
    private String contentTypeId;

    @JsonProperty("lDongRegnCd")
    @Schema(defaultValue = "30")
    private String lDongRegnCd;

    @JsonProperty("lDongSignguCd")
    @Schema(defaultValue = "200")
    private String lDongSignguCd;

    @Schema(defaultValue = "VE")
    private String lclsSystm1;

    @Schema(defaultValue = "VE07")
    private String lclsSystm2;

    @Schema(defaultValue = "VE070100")
    private String lclsSystm3;

    @Schema(defaultValue = "20250415")
    private String modifiedtime;
}
