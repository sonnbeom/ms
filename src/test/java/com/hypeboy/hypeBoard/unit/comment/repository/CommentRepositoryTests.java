package com.hypeboy.hypeBoard.unit.comment.repository;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentRepositoryTests {

    @InjectMocks
    private CommentDummyCreator commentDummyCreator;
    @Autowired
    private CommentRepository commentRepository;

    private Comment dummyComment;

    @BeforeEach
    public void setUp() {
        CommentDto dto = commentDummyCreator.createDummyCommentDto();
        Comment dummy = commentDummyCreator.createDummyCommentEntity(dto);
        dummyComment = dummy;
    }

    @Test
    public void commentRepository_findByPostId_returnNull() {
        commentRepository.save(dummyComment);

        Optional<Comment> foundComment = commentRepository.findByPost_postId(100L);
        Assertions.assertThat(foundComment.isEmpty()).isTrue();
    }

    @Test
    public void commentRepository_findByPostId_returnComment() {
        commentRepository.save(dummyComment);

        Optional<Comment> foundComment = commentRepository.findByPost_postId(dummyComment.getPost().getPostId());

        foundComment.ifPresent((c) -> {
            Assertions.assertThat(c.getPost().getPostId()).isEqualTo(dummyComment.getPost().getPostId());
            Assertions.assertThat(c.getText()).isEqualTo(dummyComment.getText());
            Assertions.assertThat(c.getUser().getId()).isEqualTo(dummyComment.getUser().getId());
        });
    }



    @Test
    public void commentRepository_save_throws() {
        dummyComment.setText(null);

        Comment savedComment = null;
        try {
             savedComment = commentRepository.save(dummyComment);
        } catch (Exception ex){
            Assertions.assertThat(savedComment).isNull();
        }
    }

    @Test
    public void commentRepository_save_returnComment() {
        Comment savedComment = commentRepository.save(dummyComment);

        Assertions.assertThat(savedComment).isNotNull();
        Assertions.assertThat(savedComment.getId()).isGreaterThan(0);
    }

}
