package com.hypeboy.hypeBoard.unit.comment.controller;

import com.hypeboy.hypeBoard.controller.CommentController;
import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.dto.ErrorDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.exception.CommentException;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.CommentService;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import com.hypeboy.hypeBoard.unit.comment.utils.CommentDummyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {
    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentDummyCreator commentDummyCreator;

    @InjectMocks
    private CommentController commentController;


    @Test
    public void createComment_Return_ModelAndView_Fail() {
        CommentDto reqDto = CommentDto.builder().build();
        BindingResult bindingResult = new BeanPropertyBindingResult(reqDto, "commentDto");
        bindingResult.rejectValue("postId", "NotEmpty", "The postId should not be empty");


        ModelAndView mv = commentController.createComment(reqDto, bindingResult);
        ErrorDto error = (ErrorDto) mv.getModel().getOrDefault("error", null);

        Assertions.assertThat(mv.getViewName()).isEqualTo(EndPoint.Path.COMMENT_FAIL);
        Assertions.assertThat(error.getMsg()).isEqualTo(bindingResult.getFieldError("postId").getDefaultMessage());
    }

    @Test
    public void createComment_Return_ModelAndView_Success() {
        CommentDto reqDto = commentDummyCreator.createDummyCommentDto();
        BindingResult bindingResult = new BeanPropertyBindingResult(reqDto, "commentDto");
        CommentDto resDto = CommentDto.builder().commentId(1).postId(reqDto.getPostId()).build();

        when(commentService.createComment(Mockito.any(CommentDto.class))).thenReturn(resDto);

        ModelAndView mv = commentController.createComment(reqDto, bindingResult);
        CommentDto result = (CommentDto) mv.getModel().getOrDefault("result", null);

        Assertions.assertThat(mv.getViewName()).isEqualTo(EndPoint.Path.COMMENT_SUCCESS);
        Assertions.assertThat(result.getCommentId()).isNotNull();
        Assertions.assertThat(result.getPostId()).isEqualTo(reqDto.getPostId());
    }
}
