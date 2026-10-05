package com.example.kuide.tour.dto.visit;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Builder
public class VisitCommonRes<T> {

    private List<T> items;
    private Integer totalCount;
}
