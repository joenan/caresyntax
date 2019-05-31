package com.caresyntax.scheduling.app.service;

public class ApiResponse<T> {

    String response;
    T data;

    public ApiResponse(String response) {
        this.response = response;
    }

    public ApiResponse(String response, T data) {
        this.response = response;
        this.data = data;
    }

    public ApiResponse() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
