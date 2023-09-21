package com.hypeboy.hypeBoard.service;


import com.hypeboy.hypeBoard.dto.CommentDto;
import com.hypeboy.hypeBoard.entity.Comment;
import com.hypeboy.hypeBoard.repository.CommentRepository;
import com.hypeboy.hypeBoard.service.converter.CommentConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentConverter commentConverter;

    public CommentDto createComment(CommentDto dto) {
        Comment comment = commentConverter.fromDtoToComment(dto);
        Comment savedComment = commentRepository.save(comment);
        CommentDto result = commentConverter.fromCommentToDto(savedComment);

        return result;
    }
}
