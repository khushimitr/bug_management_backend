package com.example.springbugtracker.model.dto.generalResponse;

import org.springframework.http.HttpStatusCode;
import org.springframework.util.MultiValueMap;

public class ApiFailureResponse<T> extends ApiResponse<T> {
    public ApiFailureResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiFailureResponse(T data, String message, HttpStatusCode status) {
        super(new MyResponse<>(false, data, message), status);
    }

    public ApiFailureResponse(String message, HttpStatusCode status) {
        super(new MyResponse<>(false, null, message), status);
    }

    public ApiFailureResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ApiFailureResponse(T data, String message, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(new MyResponse<>(false, data, message), headers, status);
    }

    public ApiFailureResponse(String message, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(new MyResponse<>(false, null, message), headers, status);
    }

    public ApiFailureResponse(T data, String message, MultiValueMap<String, String> headers, int rawStatus) {
        super(new MyResponse<>(false, data, message), headers, rawStatus);
    }

    public ApiFailureResponse(String message, MultiValueMap<String, String> headers, int rawStatus) {
        super(new MyResponse<>(false, null, message), headers, rawStatus);
    }
}
