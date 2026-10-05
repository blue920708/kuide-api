package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitLdongRes {
    @JsonProperty("lDongRegnCd")
    private String lDongRegnCd;

    @JsonProperty("lDongRegnNm")
    private String lDongRegnNm;

    @JsonProperty("lDongSignguCd")
    private String lDongSignguCd;

    @JsonProperty("lDongSignguNm")
    private String lDongSignguNm;

    private Integer rnum;
}
