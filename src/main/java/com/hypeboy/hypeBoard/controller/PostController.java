package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.UserDetailsCustom;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@Log4j2
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping(EndPoint.Path.CREATE_POST)
    public String createPost(@Valid PostDto postDto, Authentication authentication){
        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) authentication.getPrincipal();
        String nickname = userDetailsCustom.getUsername();
        String id = userDetailsCustom.getId();
        postService.postRegister(postDto, id, nickname);
        return "postComplete";
    }
}