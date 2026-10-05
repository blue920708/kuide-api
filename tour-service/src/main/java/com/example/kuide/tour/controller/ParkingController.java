package com.example.kuide.tour.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kuide.tour.dto.parking.ParkingReq;

import com.example.kuide.tour.common.ApiResult;
import com.example.kuide.tour.service.ParkingService;

@RestController
@RequiredArgsConstructor 
@RequestMapping("/api/v1/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping("/list")
    public ApiResult<?> getParkingList(@ModelAttribute ParkingReq request) {
        return parkingService.getParkingList(request);
    }
}
