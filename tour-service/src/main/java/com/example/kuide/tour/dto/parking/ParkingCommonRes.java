package com.example.kuide.tour.dto.parking;

import java.util.List;
import lombok.Builder;

import lombok.Getter;

@Getter
@Builder
public class ParkingCommonRes<T> {

    private List<T> items;
    private Integer totalCount;

}
