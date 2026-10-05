package com.example.kuide.tour.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
import com.example.kuide.tour.dto.visit.VisitAreaReq;
import com.example.kuide.tour.dto.visit.VisitAreaRes;
import com.example.kuide.tour.dto.visit.VisitCommonRes;
import com.example.kuide.tour.dto.visit.VisitDetailCommonReq;
import com.example.kuide.tour.dto.visit.VisitDetailCommonRes;
import com.example.kuide.tour.dto.visit.VisitDetailImageReq;
import com.example.kuide.tour.dto.visit.VisitDetailImageRes;
import com.example.kuide.tour.dto.visit.VisitDetailIntroReq;
import com.example.kuide.tour.dto.visit.VisitDetailIntroRes;
import com.example.kuide.tour.dto.visit.VisitDetailReq;
import com.example.kuide.tour.dto.visit.VisitDetailRes;
import com.example.kuide.tour.dto.visit.VisitLclsSystmReq;
import com.example.kuide.tour.dto.visit.VisitLclsSystmRes;
import com.example.kuide.tour.dto.visit.VisitLdongReq;
import com.example.kuide.tour.dto.visit.VisitLdongRes;
import com.example.kuide.tour.dto.visit.VisitLocationReq;
import com.example.kuide.tour.dto.visit.VisitLocationRes;
import com.example.kuide.tour.dto.visit.VisitKeywordReq;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitService {

    @Value("${external.api.visit.url}")
    private String baseUrl;

    @Value("${external.api.visit.key}")
    private String apiKey;

    private final Environment environment;
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public ApiResult<?> getLdong(VisitLdongReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.visit.endpoint.ldong"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<VisitLdongRes> ldongList = objectMapper.convertValue(
            items,
            new TypeReference<List<VisitLdongRes>>() {}
        );

        VisitCommonRes<VisitLdongRes> visitCommonRes = VisitCommonRes.<VisitLdongRes>builder()
            .items(ldongList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }

    public ApiResult<?> getLclsSystmRes(VisitLclsSystmReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.visit.endpoint.lcls"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<VisitLclsSystmRes> lclsSystmList = objectMapper.convertValue(
            items,
            new TypeReference<List<VisitLclsSystmRes>>() {}
        );

        VisitCommonRes<VisitLclsSystmRes> visitCommonRes = VisitCommonRes.<VisitLclsSystmRes>builder()
            .items(lclsSystmList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }

    public ApiResult<?> getVisitArea(VisitAreaReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.visit.endpoint.area"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<VisitAreaRes> areaList = objectMapper.convertValue(
            items,
            new TypeReference<List<VisitAreaRes>>() {}
        );

        VisitCommonRes<VisitAreaRes> visitCommonRes = VisitCommonRes.<VisitAreaRes>builder()
            .items(areaList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }

    public ApiResult<?> getVisitKeyword(VisitKeywordReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.visit.endpoint.keyword"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<VisitAreaRes> keywordList = objectMapper.convertValue(
            items,
            new TypeReference<List<VisitAreaRes>>() {}
        );

        VisitCommonRes<VisitAreaRes> visitCommonRes = VisitCommonRes.<VisitAreaRes>builder()
            .items(keywordList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }

    public ApiResult<?> getVisitLocation(VisitLocationReq request) {
        Map<String, Object> response = callApiGet(
            request,
            "external.api.visit.endpoint.location"
        );

        int totalCount = getTotalCount(response);
        List<Map<String, Object>> items = getItems(response);
        List<VisitLocationRes> locationList = objectMapper.convertValue(
            items,
            new TypeReference<List<VisitLocationRes>>() {}
        );

        VisitCommonRes<VisitLocationRes> visitCommonRes = VisitCommonRes.<VisitLocationRes>builder()
            .items(locationList)
            .totalCount(totalCount)
            .build();

        return new ApiResult<>(CommonCode.SUCCESS, visitCommonRes);
    }
    
    public ApiResult<VisitDetailRes> getVisitDetail(VisitDetailReq request) {
        String contentId = request.getContentId();
        VisitDetailCommonReq commonRequest = VisitDetailCommonReq.builder()
            .contentId(contentId)
            .numOfRows(1)
            .pageNo(1)
            .build();

        Map<String, Object> commonResponse = callApiGet(
            commonRequest,
            "external.api.visit.endpoint.detail"
        );
        List<Map<String, Object>> commonItems = getItems(commonResponse);
        if (commonItems.isEmpty()) {
            throw new IllegalStateException(
                "Visit API returned no detail for contentId: " + contentId
            );
        }
        VisitDetailCommonRes commonRes = objectMapper.convertValue(
            commonItems.get(0),
            VisitDetailCommonRes.class
        );

        VisitDetailIntroReq introRequest = VisitDetailIntroReq.builder()
            .contentId(contentId)
            .contentTypeId(commonRes.getContenttypeid())
            .numOfRows(1)
            .pageNo(1)
            .build();
        Map<String, Object> introResponse = callApiGet(
            introRequest,
            "external.api.visit.endpoint.intro"
        );
        List<Map<String, Object>> introItems = getItems(introResponse);
        if (introItems.isEmpty()) {
            throw new IllegalStateException(
                "Visit API returned no introduction for contentId: " + contentId
            );
        }
        VisitDetailIntroRes introRes = objectMapper.convertValue(
            introItems.get(0),
            VisitDetailIntroRes.class
        );

        VisitDetailImageReq imageRequest = VisitDetailImageReq.builder()
            .contentId(contentId)
            .numOfRows(1_000)
            .pageNo(1)
            .build();
        Map<String, Object> imageResponse = callApiGet(
            imageRequest,
            "external.api.visit.endpoint.image"
        );
        List<VisitDetailImageRes> imageRes = objectMapper.convertValue(
            getItems(imageResponse),
            new TypeReference<List<VisitDetailImageRes>>() {}
        );

        VisitDetailRes detail = VisitDetailRes.builder()
            .commonRes(commonRes)
            .introRes(introRes)
            .imageRes(imageRes)
            .build();
        return new ApiResult<>(CommonCode.SUCCESS, detail);
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
            throw new IllegalStateException("Visit API returned an empty response");
        }

        System.out.println("Visit API Response: " + response);

        Map<String, Object> responseMap = (Map<String, Object>) response.get("response");
        Map<String, Object> bodyMap = (Map<String, Object>) responseMap.get("body");
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
