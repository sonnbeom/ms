package com.hypeboy.hypeBoard.unit.comment.utils;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.entity.User;
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
        Post post = new Post();
        post.setPostId((long) dto.getPostId());

        User user = new User();
        user.setId(dto.getUserId());

        boolean hasParentId = dto.getParentId() != null;
        Comment parent = new Comment();
        if (hasParentId) parent.setId((long) dto.getParentId());

        Comment comment = new Comment();
        comment.setId(1L);
        comment.setPost(post);
        comment.setText(dto.getText());
        comment.setUser(user);
        comment.setUpdatedAt(LocalDateTime.now());
        if (hasParentId) comment.setParent(parent);

        return comment;
    }

    public CommentDto createDummyCommentResDto(Comment comment) {
        CommentDto resDto = CommentDto.builder()
                .commentId(Math.toIntExact(comment.getId()))
                .postId(Math.toIntExact(comment.getPost().getPostId()))
                .userId(comment.getUser().getId())
                .text(comment.getText())
                .updatedAt(comment.getUpdatedAt())
                .build();

        return resDto;
    }
}
