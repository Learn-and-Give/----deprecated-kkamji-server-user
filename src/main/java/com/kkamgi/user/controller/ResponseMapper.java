package com.kkamgi.user.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseMapper<T> {
    private int code;
    private String message;
    private T result;

    public ResponseMapper(final int code, final String message) {
        this.code = code;
        this.message = message;
        this.result = null;
    }

    public static<T> ResponseMapper<T> res(final int statusCode, final String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    public static<T> ResponseMapper<T> res(final int statusCode, final String responseMessage, final T t) {
        return ResponseMapper.<T>builder()
                .result(t)
                .code(statusCode)
                .message(responseMessage)
                .build();
    }
}
