package com.example.springbugtracker.model.dto.generalResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyResponse<T> {

    public Boolean success;

    public T data;

    public String message;
}
