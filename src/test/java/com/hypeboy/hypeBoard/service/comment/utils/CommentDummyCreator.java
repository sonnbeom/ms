package com.hypeboy.hypeBoard.service.comment.utils;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentDummyCreator {
    public CommentDto createDummyCommentDto() {
        return CommentDto.builder()
                .postId(1)
                .userId("test1")
                .text("This is the test comment")
                .build();
    }

    public Comment createDummyCommentEntity(CommentDto dto) {
        return  Comment.builder()
                .id(1L)
                .postId((long) dto.getPostId())
                .userId(dto.getUserId())
                .text(dto.getText())
                .updatedAt(LocalDateTime.now())
                .parentId(null)
                .build();
    }
}
