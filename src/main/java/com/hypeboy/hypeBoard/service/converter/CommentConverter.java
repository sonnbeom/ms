package com.hypeboy.hypeBoard.service.converter;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public Comment fromDtoToComment(CommentDto dto) {
        return Comment.builder()
                .postId((long) dto.getPostId())
                .userId(dto.getUserId())
                .text(dto.getText())
                .parentId(dto.getParentId() != null ? (long) dto.getParentId() : null)
                .build();
    }

    public CommentDto fromCommentToDto(Comment comment) {
        Integer parentId = comment.getParentId() != null
                ? Math.toIntExact(comment.getParentId())
                : null;

        return CommentDto.builder()
                .commentId(Math.toIntExact(comment.getId()))
                .postId(Math.toIntExact(comment.getPostId()))
                .userId(comment.getUserId())
                .text(comment.getText())
                .parentId(parentId)
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
