package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.page.Page;
import com.hypeboy.hypeBoard.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

//@Controller
@RestController
@Log4j2
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping(EndPoint.Path.CREATE_POST)
    public String createPost(@Valid PostDto postDto) throws SQLException {

        return "postComplete";
    }

    @PostMapping(EndPoint.Path.READ_BY_NICKNAME)
    public String readPostByNickname(@Valid String nickname, @PathVariable int currentPage, Model model){
        Page<PostDto> page = postService.createPageByNickName(nickname,currentPage+1);
        model.addAttribute("page",page);
        return "";
    }
    @PostMapping(EndPoint.Path.READ_BY_ID)
    public String readPostById(@Valid String id, @PathVariable int currentPage, Model model){
        Page<PostDto> page = postService.createPageById(id,currentPage+1);
        model.addAttribute("page",page);
        return "";
    }

    @GetMapping(EndPoint.Path.UPDATE)
    public String updateMyPost(@RequestBody PostDto postDto, @PathVariable String id, @PathVariable int postId){
        postService.updatePost(postDto, id, postId);
        return "";
    }

    @GetMapping(EndPoint.Path.DELETE)
    public String deleteMyPost(@PathVariable String id, @PathVariable int postId) throws SQLException {
        postService.delete(id, postId);
        return "";
    }
}