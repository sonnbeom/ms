package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.page.Page;
import com.hypeboy.hypeBoard.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

//@Controller
@Controller
@Log4j2
public class PostController {
    @Autowired
    private PostService postService;

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
    @PostMapping(EndPoint.Path.CREATE_POST)
    public String createPost(@Valid @ModelAttribute PostDto postDto, BindingResult bindingResult, @RequestParam("id")String id, @RequestParam("nickname")String nickname) throws SQLException {
        if (bindingResult.hasErrors()){
            return "redirect:/create_post";
        }
        postService.postRegister(postDto, id, nickname);
        return "/posts";
    }
    @GetMapping(EndPoint.Path.CREATE_POST)
    public String createPostPage(){
        return "create_post";
    }
}