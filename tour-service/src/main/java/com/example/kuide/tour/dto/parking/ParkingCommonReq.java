package com.example.kuide.tour.dto.parking;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ParkingCommonReq {
    
    @Schema(defaultValue = "100")
    @Builder.Default
    private Integer numOfRows = 100;

    @Schema(defaultValue = "1")
    @Builder.Default
    private Integer pageNo = 1;

    @Schema(defaultValue = "json")
    @Builder.Default
    private String type = "json";
}
