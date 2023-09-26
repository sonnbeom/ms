package com.hypeboy.hypeBoard.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Comment {
    private Integer id;

    private final Integer postId;
    private final String userId;
    private final String text;
    private CommentStatus status;

    private Integer parentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Comment(Integer id, Integer postId, String userId, String text, Integer parentId, CommentStatus status) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.parentId = parentId;
        this.status = status;
    }

}