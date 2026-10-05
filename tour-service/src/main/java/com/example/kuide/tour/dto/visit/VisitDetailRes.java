package com.example.kuide.tour.dto.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import lombok.Builder;

@Getter 
@Builder     
public class VisitDetailRes {
    private VisitDetailCommonRes commonRes;
	private VisitDetailIntroRes introRes;
	private List<VisitDetailImageRes> imageRes;
}
