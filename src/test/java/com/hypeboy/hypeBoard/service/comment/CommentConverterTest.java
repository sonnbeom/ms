package com.hypeboy.hypeBoard.service.comment;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.dto.ResponseDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.service.comment.utils.CommentDummyCreator;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import org.assertj.core.api.Assertions;
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

    @Test
    public void fromDtoToComment_Return_Comment() {
        CommentDto dummyDto = commentDummyCreator.createDummyCommentDto();
        Comment comment = commentConverter.fromDtoToComment(dummyDto);

        Assertions.assertThat(comment).isNotNull();
        Assertions.assertThat(comment.getPostId()).isNotNull();
        Assertions.assertThat(comment.getUserId()).isNotNull();
        Assertions.assertThat(comment.getText()).isNotNull();
    }

    @Test
    public void fromCommentToResponse_Return_ResponseDto() {
        CommentDto dummyDto = commentDummyCreator.createDummyCommentDto();
        Comment dummyComment = commentDummyCreator.createDummyCommentEntity(dummyDto);

        ResponseDto<CommentDto> result = commentConverter
                .fromCommentToResponse(dummyComment);

        Assertions.assertThat(result.isOk()).isTrue();
        Assertions.assertThat(result.getData().getPostId()).isEqualTo(dummyDto.getPostId());
    }
}
