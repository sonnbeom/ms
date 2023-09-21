package com.hypeboy.hypeBoard.service.converter;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    @PersistenceContext
    private EntityManager entityManager;
    public Comment fromDtoToComment(CommentDto dto) {
        User userReference = entityManager.getReference(User.class, dto.getUserId());

        return Comment.builder()
                .postId((long) dto.getPostId())
                .user(userReference)
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
                .userId(comment.getUser().getId())
                .text(comment.getText())
                .parentId(parentId)
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
