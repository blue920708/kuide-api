package com.example.kuide.tour.common;

public class BizException extends RuntimeException {
    private final EnumMapperType code;

    public BizException(EnumMapperType code) {
        super(code.getMessage());
        this.code = code;
    }

    public EnumMapperType code() {
        return code;
    }

    public String getCode() {
        return code.getCode();
    }
}
