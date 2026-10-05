package com.example.kuide.tour.dto.visit;

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
public class VisitCommonReq {
    
    @Schema(defaultValue = "1000000")
    @Builder.Default
    private Integer numOfRows = 1000000;

    @Schema(defaultValue = "1")
    @Builder.Default
    private Integer pageNo = 1;

    @Schema(defaultValue = "ETC")
    @Builder.Default
    private String mobileOS = "ETC";

    @Schema(defaultValue = "App")
    @Builder.Default
    private String mobileApp = "App";

    @JsonProperty("_type")
    @Schema(defaultValue = "json")
    @Builder.Default
    private String _type = "json";

}
