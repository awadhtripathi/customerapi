package com.demo.en.customerservice.exception;

public class ApiResponse<T> {
    private String status;
    private T data;
    private ApiErrorResponse error;

    public ApiResponse(String status, T data, ApiErrorResponse error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiErrorResponse getError() {
        return error;
    }

    public void setError(ApiErrorResponse error) {
        this.error = error;
    }
}
