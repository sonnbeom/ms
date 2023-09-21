package com.hypeboy.hypeBoard.service.converter;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    @PersistenceContext
    private EntityManager entityManager;
    public Comment fromDtoToComment(CommentDto dto) {
        User userRef = entityManager.getReference(User.class, dto.getUserId());
        Post postRef = entityManager.getReference(Post.class, (long) dto.getPostId());
        Comment commentRef = dto.getParentId() != null
                ? entityManager.getReference(Comment.class, dto.getParentId())
                : null;

        Comment c = new Comment();
        c.setPost(postRef);
        c.setUser(userRef);
        c.setText(dto.getText());
        c.setParent(commentRef);


        return c;
    }

    public CommentDto fromCommentToDto(Comment comment) {
        Integer parentId = comment.getParent() != null
                ? Math.toIntExact(comment.getParent().getId())
                : null;

        return CommentDto.builder()
                .commentId(Math.toIntExact(comment.getId()))
                .postId(Math.toIntExact(comment.getPost().getPostId()))
                .userId(comment.getUser().getId())
                .text(comment.getText())
                .parentId(parentId)
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
