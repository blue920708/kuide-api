package com.example.kuide.tour.service;

import java.net.URI;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.kuide.tour.common.ApiResult;
import com.example.kuide.tour.common.CommonCode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final Environment environment;
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public <T> ApiResult<T> callApiGet(
        String baseUrl,
        String apiKey,
        Object request,
        String endpointProperty,
        ParameterizedTypeReference<T> responseType
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
            throw new IllegalStateException("External API returned an empty response");
        }

        Map<String, Object> responseWrapper = (Map<String, Object>) response.get("response");
        Map<String, Object> body = responseWrapper == null
            ? null
            : (Map<String, Object>) responseWrapper.get("body");
        if (body == null || "".equals(body.get("items"))) {
            return new ApiResult<>(CommonCode.SUCCESS, null);
        }

        T result = objectMapper.convertValue(
            response,
            objectMapper.getTypeFactory().constructType(responseType.getType())
        );
        return new ApiResult<>(CommonCode.SUCCESS, result);
    }
}
