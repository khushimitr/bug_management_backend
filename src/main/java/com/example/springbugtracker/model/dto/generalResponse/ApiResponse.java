package com.example.springbugtracker.model.dto.generalResponse;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ApiResponse<T> extends ResponseEntity<MyResponse<T>> {
    public ApiResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiResponse(MyResponse<T> body, HttpStatusCode status) {
        super(body, status);
    }

    public ApiResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ApiResponse(MyResponse<T> body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public ApiResponse(MyResponse<T> body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
