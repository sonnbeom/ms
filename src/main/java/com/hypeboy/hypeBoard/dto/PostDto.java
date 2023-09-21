package com.hypeboy.hypeBoard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
