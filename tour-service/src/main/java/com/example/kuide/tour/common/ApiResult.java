package com.example.kuide.tour.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResult<T>(String code, String msg, T data) {

    public ApiResult(EnumMapperType en, T data) {
        this(en.getCode(), en.getMessage(), data);
    }

    public ApiResult(EnumMapperType en) {
        this(en.getCode(), en.getMessage(), null);
    }
}