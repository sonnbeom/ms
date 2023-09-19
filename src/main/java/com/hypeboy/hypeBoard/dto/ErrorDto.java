package com.hypeboy.hypeBoard.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private String code;
    private String msg;

    public ErrorDto(String msg) {
        this.msg = msg;
    }
}
