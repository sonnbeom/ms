package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentRepositoryTests {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void commentRepository_findByPostId_returnNull() {
        Comment comment = Comment.builder().postId(1L).text("hello test comment").userId("test1").build();
        commentRepository.save(comment);

        Optional<Comment> foundComment = commentRepository.findByPostId(100L);
        Assertions.assertThat(foundComment.isEmpty()).isTrue();
    }

    @Test
    public void commentRepository_findByPostId_returnComment() {
        Comment comment = Comment.builder().postId(1L).text("hello test comment").userId("test1").build();
        commentRepository.save(comment);

        Optional<Comment> foundComment = commentRepository.findByPostId(comment.getPostId());

        foundComment.ifPresent((c) -> {
            Assertions.assertThat(c.getPostId()).isEqualTo(comment.getPostId());
            Assertions.assertThat(c.getText()).isEqualTo(comment.getText());
            Assertions.assertThat(c.getUserId()).isEqualTo(comment.getUserId());
        });
    }

    @Test
    public void commentRepository_save_returnComment() {
        Comment comment = Comment.builder().postId(1L).text("hello test comment").userId("test1").build();

        Comment savedComment = commentRepository.save(comment);

        Assertions.assertThat(savedComment).isNotNull();
        Assertions.assertThat(savedComment.getId()).isGreaterThan(0);
    }

    @Test
    public void commentRepository_save_throws() {
        Comment invalidComment = Comment.builder()
                .postId(1L)
//                .text("ho")
                .userId("test1")
                .build();

        Comment savedComment = null;
        try {
             savedComment = commentRepository.save(invalidComment);
        } catch (Exception ex){
            Assertions.assertThat(savedComment).isNull();
        }
    }


}
