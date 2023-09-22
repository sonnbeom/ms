package com.hypeboy.hypeBoard.entity;


import com.hypeboy.hypeBoard.dto.PostDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    private int id;

    private String userId;

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;

    private String nickname;

    private String textContent;

    @NotBlank(message = "카테고리는 필수 입력 값입니다.")
    private String category;

    private int referencedId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Post(int id, String userId, String title, String nickname ,String textContent, String category, int referencedId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.textContent = textContent;
        this.category = category;
        this.referencedId = referencedId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nickname = nickname;

    }
    public Post(PostDto postDto){
        this.title = postDto.getTitle();
        this.textContent = postDto.getTextContent();
        this.category = postDto.getCategory();
        this.nickname = postDto.getNickname();
        this.userId = postDto.getUserId();
    }
//    public Post() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }

}
