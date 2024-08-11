package com.demo.en.customerservice.exception;

public enum ApiErrorCode {
    CUSTOMER_NOT_FOUND("CUST_404", "Customer not found"),
    INVALID_SEARCH_PARAMETERS("CUST_400", "Invalid search parameters"),
    GENERAL_ERROR("CUST_500", "An unexpected error occurred");

    private final String code;
    private final String message;

    ApiErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
