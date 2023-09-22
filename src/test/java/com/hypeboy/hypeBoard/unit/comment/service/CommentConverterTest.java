package com.hypeboy.hypeBoard.unit.comment.service;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommentConverterTest {

    @InjectMocks
    private CommentDummyCreator commentDummyCreator;

    @InjectMocks
    private CommentConverter commentConverter;

    private Comment dummyComment;
    private CommentDto dummyDto;

    @BeforeEach
    public void setUp() {
        CommentDto dto = commentDummyCreator.createDummyCommentDto();
        Comment comment = commentDummyCreator.createDummyCommentEntity(dto);
        dummyDto = dto;
        dummyComment = comment;
    }

    @Test
    public void fromDtoToComment_Return_Comment() {

        Assertions.assertThat(dummyComment).isNotNull();
        Assertions.assertThat(dummyComment.getPost().getPostId()).isEqualTo((long) dummyDto.getPostId());
        Assertions.assertThat(dummyComment.getUser().getId()).isEqualTo(dummyDto.getUserId());
        Assertions.assertThat(dummyComment.getText()).isEqualTo(dummyDto.getText());
    }

    @Test
    public void fromCommentToDto_Return_Dto() {
        CommentDto convertedDto = commentConverter.fromCommentToDto(dummyComment);

        Assertions.assertThat(convertedDto).isNotNull();
        Assertions.assertThat(convertedDto.getPostId()).isEqualTo(Math.toIntExact(dummyComment.getPost().getPostId()));
        Assertions.assertThat(convertedDto.getUserId()).isEqualTo(dummyComment.getUser().getId());
        Assertions.assertThat(convertedDto.getText()).isEqualTo(dummyComment.getText());
    }
}
