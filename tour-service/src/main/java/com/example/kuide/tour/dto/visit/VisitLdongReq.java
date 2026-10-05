package com.example.kuide.tour.dto.visit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class VisitLdongReq extends VisitCommonReq {

    @Schema(defaultValue = "11")
    @JsonProperty("lDongRegnCd")
    private String lDongRegnCd;

    @Schema(defaultValue = "Y")
    @JsonProperty("lDongListYn")
    private String lDongListYn;
}
