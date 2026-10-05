package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class VisitDetailImageRes {
	private String contentid;
    private String imgname;
    private String originimgurl;
    private String smallimageurl;
    private String cpyrhtDivCd;
    private String serialnum;
}
