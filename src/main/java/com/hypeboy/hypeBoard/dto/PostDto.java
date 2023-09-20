package com.hypeboy.hypeBoard.dto;

import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
public class PostDto {
    @NotNull
    private String title;
    private String textContent;
    @NotNull
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
