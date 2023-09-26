package com.hypeboy.hypeBoard.unit.comment.service;

import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.CommentService;
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
    private CommentService commentService;


    private CommentDto dummyDto;
    private Comment dummyComment;
    private CommentDto dummyResDto;

    @BeforeEach
    public void setUp() {
        dummyDto = null;
        dummyComment = null;
        dummyResDto = null;
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

}
