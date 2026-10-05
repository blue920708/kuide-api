package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitLocationRes {
    private String addr1;
    private String addr2;
    private String zipcode;
    private String areacode;

    private String cat1;
    private String cat2;
    private String cat3;

    private String contentid;
    private String contenttypeid;

    private String createdtime;
    private String dist;

    private String firstimage;
    private String firstimage2;
    private String cpyrhtDivCd;

    private String mapx;
    private String mapy;
    private String mlevel;

    private String modifiedtime;
    private String sigungucode;
    private String tel;
    private String title;

    @JsonProperty("lDongRegnCd")
    private String lDongRegnCd;

    @JsonProperty("lDongSignguCd")
    private String lDongSignguCd;

    private String lclsSystm1;
    private String lclsSystm2;
    private String lclsSystm3;
}
