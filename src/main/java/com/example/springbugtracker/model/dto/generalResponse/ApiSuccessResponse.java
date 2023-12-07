package com.example.springbugtracker.model.dto.generalResponse;

import org.springframework.http.HttpStatusCode;
import org.springframework.util.MultiValueMap;

public class ApiSuccessResponse<T> extends ApiResponse<T> {
    public ApiSuccessResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiSuccessResponse(T data, HttpStatusCode status) {
        super(new MyResponse<>(true, data, "success"), status);
    }

    public ApiSuccessResponse(T data, String message, HttpStatusCode status) {
        super(new MyResponse<>(true, data, message), status);
    }

    public ApiSuccessResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ApiSuccessResponse(T data, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(new MyResponse<>(true, data, "success"), headers, status);
    }

    public ApiSuccessResponse(T data, String message, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(new MyResponse<>(true, data, message), headers, status);
    }

    public ApiSuccessResponse(T data, MultiValueMap<String, String> headers, int rawStatus) {
        super(new MyResponse<>(true, data, "success"), headers, rawStatus);
    }

    public ApiSuccessResponse(T data, String message, MultiValueMap<String, String> headers, int rawStatus) {
        super(new MyResponse<>(true, data, message), headers, rawStatus);
    }
}
