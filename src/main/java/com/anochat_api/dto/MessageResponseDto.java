package com.anochat_api.dto;

public class MessageResponseDto {
    private String message;
    private String sort;

    public String getMessage() {
        return message;
    }

    public String getSort() {
        return sort;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
