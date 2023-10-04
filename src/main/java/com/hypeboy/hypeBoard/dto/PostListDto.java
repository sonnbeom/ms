package com.hypeboy.hypeBoard.dto;

import lombok.Data;

@Data
public class PostListDto {
    private final Integer page;
    private final Integer limit;

    public static PostListDto getDefaultInstance() {
        return new PostListDto(1, 10);
    }
}
