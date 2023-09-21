package com.hypeboy.hypeBoard.unit.comment.controller;

import com.hypeboy.hypeBoard.controller.CommentController;
import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.dto.ErrorDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.service.CommentService;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {
    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentDummyCreator commentDummyCreator;

    @InjectMocks
    private CommentController commentController;

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
    public void createComment_Return_ModelAndView_Fail() {
        String field = "postId";

        BindingResult bindingResult = new BeanPropertyBindingResult(dummyDto, "commentDto");
        bindingResult.rejectValue(field, "NotEmpty", "The postId should not be empty");

        ModelAndView mv = commentController.createComment(dummyDto, bindingResult);
        ErrorDto error = (ErrorDto) mv.getModel().getOrDefault("error", null);

        Assertions.assertThat(mv.getViewName()).isEqualTo(EndPoint.Path.COMMENT_FAIL);
        Assertions.assertThat(error.getMsg()).isEqualTo(bindingResult.getFieldError(field).getDefaultMessage());
    }

    @Test
    public void createComment_Return_ModelAndView_Success() {
        BindingResult bindingResult = new BeanPropertyBindingResult(dummyDto, "commentDto");

        when(commentService.createComment(Mockito.any(CommentDto.class))).thenReturn(dummyResDto);

        ModelAndView mv = commentController.createComment(dummyDto, bindingResult);
        CommentDto result = (CommentDto) mv.getModel().getOrDefault("result", null);

        Assertions.assertThat(mv.getViewName()).isEqualTo(EndPoint.Path.COMMENT_SUCCESS);
        Assertions.assertThat(result.getCommentId()).isNotNull();
        Assertions.assertThat(result.getPostId()).isEqualTo(dummyDto.getPostId());
    }
}
