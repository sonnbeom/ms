package com.hypeboy.hypeBoard.service;


import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentConverter commentConverter;
    public CommentDto createComment(CommentDto dto) {

        Comment comment = commentConverter.fromDtoToComment(dto);
        Comment savedComment = commentRepository.save(comment);
        CommentDto resDto = commentConverter.fromCommentToDto(savedComment);

        return resDto;
    }
}
