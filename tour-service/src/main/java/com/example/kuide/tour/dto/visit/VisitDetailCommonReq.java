package com.example.kuide.tour.dto.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter 
@Setter
@SuperBuilder
public class VisitDetailCommonReq extends VisitCommonReq {
    private String contentId;
}
