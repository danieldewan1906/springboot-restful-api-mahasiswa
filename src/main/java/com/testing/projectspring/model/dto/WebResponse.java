package com.testing.projectspring.model.dto;

import lombok.Data;

@Data
public class WebResponse<T> {

    private Integer code;
    private String status;
    private T data;

    public WebResponse(Integer code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
