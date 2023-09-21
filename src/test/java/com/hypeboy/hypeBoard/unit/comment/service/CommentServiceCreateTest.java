package com.hypeboy.hypeBoard.unit.comment.service;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.CommentService;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import org.assertj.core.api.Assertions;
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


    @Test
    void createComment_Fail_with_repository() {
        String errorMsg = "Invalid Dto";
        CommentDto reqDto = commentDummyCreator.createDummyCommentDto();
        Comment commentDummy = commentDummyCreator.createDummyCommentEntity(reqDto);

        when(commentConverter.fromDtoToComment(Mockito.any(CommentDto.class)))
                .thenReturn(commentDummy);

        when(commentRepository.save(Mockito.any(Comment.class)))
                .thenThrow(new RuntimeException(errorMsg));


        try {
            commentService.createComment(reqDto);
        } catch (Exception ex) {
            Assertions.assertThat(ex.getMessage()).isEqualTo(errorMsg);
        }
    }

    @Test
    public void createComment_Fail_with_invalidDto() {
        String errorMsg = "Invalid Dto";
        CommentDto invalidDto = CommentDto.builder().build();

        when(commentConverter.fromDtoToComment(invalidDto))
                .thenThrow(new RuntimeException(errorMsg));

        try {
            commentService.createComment(invalidDto);
        } catch (Exception ex) {
            Assertions.assertThat(ex.getMessage()).isEqualTo(errorMsg);
        }
    }

    @Test
    public void createComment_Returns_SuccessCommentDto() {
        CommentDto reqDto = commentDummyCreator.createDummyCommentDto();
        Comment commentDummy = commentDummyCreator.createDummyCommentEntity(reqDto);

        CommentDto resDto = CommentDto.builder()
                .commentId(Math.toIntExact(commentDummy.getId()))
                .postId(Math.toIntExact(commentDummy.getPostId()))
                .userId(commentDummy.getUserId())
                .text(commentDummy.getText())
                .updatedAt(commentDummy.getUpdatedAt())
                .build();

        when(commentConverter.fromDtoToComment(Mockito.any(CommentDto.class)))
                .thenReturn(commentDummy);

        when(commentConverter.fromCommentToDto(Mockito.any(Comment.class)))
                .thenReturn(resDto);

        when(commentRepository.save(Mockito.any(Comment.class)))
                .thenReturn(commentDummy);

        CommentDto dto = commentService.createComment(reqDto);

        Assertions.assertThat(dto).isNotNull();
        Assertions.assertThat(dto.getCommentId()).isEqualTo(Math.toIntExact(commentDummy.getId()));
    }
}