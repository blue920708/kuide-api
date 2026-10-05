package com.example.kuide.tour.dto.visit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter 
@SuperBuilder 
@Setter
public class VisitDetailIntroReq extends VisitCommonReq {
    private String contentId;
    private String contentTypeId;

}
