package com.example.kuide.tour.common;

public enum CommonCode implements EnumMapperType {
    SUCCESS("0000", "Success"),
    FAIL("9999", "Internal server error");

    private final String code;
    private final String message;

    CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
