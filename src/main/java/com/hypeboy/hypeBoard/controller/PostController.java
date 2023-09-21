package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.service.PostLikeService;
import com.hypeboy.hypeBoard.service.PostService;
import com.hypeboy.hypeBoard.service.ViewCounterService;
import com.hypeboy.hypeBoard.sessioncheck.SessionCheckHandler;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@Log4j2
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private SessionCheckHandler sessionCheck;

    @Autowired
    private ViewCounterService counterService;
    @Autowired
    private PostLikeService postLikeService;

    @PostMapping(EndPoint.Path.CREATE_POST)
    public String createPost(@Valid PostDto postDto){
        Authentication auth = sessionCheck.getAuthentication();
        User user = (User) auth.getPrincipal();
        postService.postRegister(postDto,user);
        return "postComplete";
    }
    @PostMapping(EndPoint.Path.CLICK_POST)
    public String viewCount(@PathVariable Long postId){
        counterService.increaseViewCount(postId);
        return "";
    }
    @PostMapping(EndPoint.Path.CLICK_LIKE)
    public String likeCount(@PathVariable Long postId, @PathVariable String userID){
        postLikeService.likeDeciding(postId,userID);
        return "";
    }
}
