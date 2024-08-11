package com.demo.en.customerservice.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private String status;
    private String code;
    private String message;

    public ApiErrorResponse(String code, String message) {
        this.status = "error";
        this.code = code;
        this.message = message;
    }


}
