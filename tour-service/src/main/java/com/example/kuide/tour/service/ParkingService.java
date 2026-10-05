package com.example.kuide.tour.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.kuide.tour.common.ApiResult;
import com.example.kuide.tour.common.CommonCode;
import com.example.kuide.tour.dto.parking.ParkingReq;
import com.example.kuide.tour.dto.parking.ParkingRes;
import com.example.kuide.tour.dto.parking.ParkingCommonRes;
import com.example.kuide.tour.dto.visit.VisitCommonRes;
import com.example.kuide.tour.dto.visit.VisitLocationRes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {

    @Value("${external.api.parking.url}")
    private String baseUrl;

    @Value("${external.api.parking.key}")
    private String apiKey;

    private final Environment environment;
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public ApiResult<?> getParkingList(ParkingReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.parking.endpoint.list"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<ParkingRes> parkingList = objectMapper.convertValue(
            items
            , new TypeReference<List<ParkingRes>>() {}
        );

        ParkingCommonRes<ParkingRes> visitCommonRes = ParkingCommonRes.<ParkingRes>builder()
            .items(parkingList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }

    private Map<String, Object> callApiGet(
        Object request,
        String endpointProperty
    ) {
        String endpoint = environment.getProperty(endpointProperty);
        Map<String, Object> requestMap = objectMapper.convertValue(
            request,
            new TypeReference<Map<String, Object>>() {}
        );
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        requestMap.forEach((key, value) -> {
            if (value != null) {
                params.add(key, String.valueOf(value));
            }
        });
        params.add("serviceKey", apiKey);

        URI uri = UriComponentsBuilder
            .fromUriString(baseUrl)
            .path(endpoint)
            .queryParams(params)
            .build()
            .encode()
            .toUri();

        Map<String, Object> response = restClient.get()
            .uri(uri)
            .retrieve()
            .body(new ParameterizedTypeReference<Map<String, Object>>() {});
        if (response == null) {
            throw new IllegalStateException("Parking API returned an empty response");
        }

        System.out.println("Parking API Response: " + response);

        Map<String, Object> bodyMap = (Map<String, Object>) response.get("body");
        if(bodyMap == null || "".equals(bodyMap.get("items"))) {
            return new HashMap<>();
        }

        return bodyMap;
    }

    private List<Map<String, Object>> getItems(Map<String, Object> response) {
        Map<String, Object> itemsMap = (Map<String, Object>) response.get("items");
        if (itemsMap == null) {
            return List.of();
        }

        Object item = itemsMap.get("item");
        if (item instanceof List<?>) {
            return objectMapper.convertValue(item, new TypeReference<List<Map<String, Object>>>() {});
        }
        if (item instanceof Map<?, ?>) {
            return List.of(objectMapper.convertValue(item, new TypeReference<Map<String, Object>>() {}));
        }
        return List.of();
    }

    private int getTotalCount(Map<String, Object> response) {
        Number totalCount = (Number) response.get("totalCount");
        return totalCount == null ? 0 : totalCount.intValue();
    }
}
