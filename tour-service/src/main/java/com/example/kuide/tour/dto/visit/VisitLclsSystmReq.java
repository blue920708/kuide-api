package com.example.kuide.tour.dto.visit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class VisitLclsSystmReq extends VisitCommonReq {
    @Schema(defaultValue = "AC")
    private String lclsSystm1;

    @Schema(defaultValue = "AC01")
    private String lclsSystm2;

    @Schema(defaultValue = "AC010100")
    private String lclsSystm3;

    @Schema(defaultValue = "Y")
    private String lclsSystmListYn;
}
