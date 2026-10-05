package com.example.kuide.tour.dto.visit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Getter 
@SuperBuilder 
@Setter
public class VisitDetailImageReq extends VisitCommonReq {
    
	@Schema(defaultValue = "2901530")
    private String contentId;
}
