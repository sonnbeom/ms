package com.hypeboy.hypeBoard.exceptioncontroller;

import com.hypeboy.hypeBoard.dto.PostDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationCheckController {

    @Autowired
    private Validator validator;

    public List<String> validatePostDto(PostDto postDto) {
        Set<ConstraintViolation<PostDto>> violations = validator.validate(postDto);
        List<String> erMsg = new ArrayList<>();
        for (ConstraintViolation<PostDto> violation : violations) {
            erMsg.add(violation.getMessage());
        } return erMsg;
     }
    }

