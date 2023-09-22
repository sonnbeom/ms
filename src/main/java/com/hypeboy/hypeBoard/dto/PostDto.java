package com.hypeboy.hypeBoard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    private String textContent;
    @NotBlank(message = "카테고리는 필수 입력 값입니다.")
    private String category;
    private String nickname;
    private String userId;

    public PostDto(String title, String textContent, String category, String nickname, String userId) {
        this.title = title;
        this.textContent = textContent;
        this.category = category;
        this.nickname = nickname;
        this.userId = userId;
    }

    public PostDto(String title, String textContent, String category) {
        this.title = title;
        this.textContent = textContent;
        this.category = category;
    }

}
