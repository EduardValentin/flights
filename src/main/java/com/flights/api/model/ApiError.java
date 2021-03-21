package com.flights.api.model;

import java.util.List;

public class ApiError {

    private final String message;
    private final List<String> errorsDetails;

    public ApiError(String message, List<String> errorsDetails) {
        this.message = message;
        this.errorsDetails = errorsDetails;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getErrorsDetails() {
        return this.errorsDetails;
    }
}
