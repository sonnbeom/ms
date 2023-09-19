package com.hypeboy.hypeBoard.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CommentDto {
    private int postId;
    private String userId;
    private String text;

    private int parentId;
    private int commentId;
    private LocalDateTime updatedAt;

}

