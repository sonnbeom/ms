package com.hypeboy.hypeBoard.dto;

import lombok.Data;

@Data
public class ResponseDto<T> {
    private boolean isOk = true;
    private T data;
    private ErrorDto error;

    public ResponseDto(T data) {
        this.data = data;
    }

    public ResponseDto(String message) {
        this.isOk = false;
        this.error = new ErrorDto(message);
    }
}
