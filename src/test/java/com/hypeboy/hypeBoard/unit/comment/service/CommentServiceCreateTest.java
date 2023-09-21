package com.hypeboy.hypeBoard.unit.comment.service;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.CommentService;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceCreateTest {
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentConverter commentConverter;

    @InjectMocks
    private CommentDummyCreator commentDummyCreator;

    @InjectMocks
    private CommentService commentService;


    private CommentDto dummyDto;
    private Comment dummyComment;
    private CommentDto dummyResDto;

    @BeforeEach
    public void setUp() {
        dummyDto = commentDummyCreator.createDummyCommentDto();
        dummyComment = commentDummyCreator.createDummyCommentEntity(dummyDto);
        dummyResDto = commentDummyCreator.createDummyCommentResDto(dummyComment);
    }

    @Test
    void createComment_Fail_with_repository() {
        String errorMsg = "Invalid Dto";

        when(commentConverter.fromDtoToComment(Mockito.any(CommentDto.class)))
                .thenReturn(dummyComment);

        when(commentRepository.save(Mockito.any(Comment.class)))
                .thenThrow(new RuntimeException(errorMsg));

        try {
            commentService.createComment(dummyDto);
        } catch (Exception ex) {
            Assertions.assertThat(ex.getMessage()).isEqualTo(errorMsg);
        }
    }

    @Test
    public void createComment_Fail_with_invalidDto() {
        String errorMsg = "Invalid Dto";

        when(commentConverter.fromDtoToComment(Mockito.any(CommentDto.class)))
                .thenThrow(new RuntimeException(errorMsg));

        try {
            commentService.createComment(dummyDto);
        } catch (Exception ex) {
            Assertions.assertThat(ex.getMessage()).isEqualTo(errorMsg);
        }
    }

    @Test
    public void createComment_Returns_SuccessCommentDto() {
        when(commentConverter.fromDtoToComment(Mockito.any(CommentDto.class)))
                .thenReturn(dummyComment);

        when(commentConverter.fromCommentToDto(Mockito.any(Comment.class)))
                .thenReturn(dummyResDto);

        when(commentRepository.save(Mockito.any(Comment.class)))
                .thenReturn(dummyComment);

        CommentDto dto = commentService.createComment(dummyDto);

        Assertions.assertThat(dto).isNotNull();
        Assertions.assertThat(dto.getCommentId()).isEqualTo(Math.toIntExact(dummyComment.getId()));
    }
}
