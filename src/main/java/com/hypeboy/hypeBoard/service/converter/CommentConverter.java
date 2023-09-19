package com.hypeboy.hypeBoard.service.converter;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.dto.ResponseDto;
import com.hypeboy.hypeBoard.entity.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentConverter {
    public Comment fromDtoToComment(CommentDto dto) {
        // validation 필요
        return Comment.builder()
                .postId((long) dto.getPostId())
                .userId(dto.getUserId())
                .text(dto.getText())
                .updatedAt(LocalDateTime.now())
                .parentId(dto.getParentId() == 0 ? null : (long) dto.getParentId())
                .build();
    }

    public ResponseDto<CommentDto> fromCommentToResponse(Comment comment) {
        CommentDto dto = this.fromCommentToDto(comment);
        return new ResponseDto<>(dto);
    }

    private CommentDto fromCommentToDto(Comment comment) {
        return CommentDto.builder()
                .commentId(Math.toIntExact(comment.getId()))
                .postId(Math.toIntExact(comment.getPostId()))
                .userId(comment.getUserId())
                .text(comment.getText())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
