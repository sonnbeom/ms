package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post postRegister(PostDto postDto, User user){
        Post post = postToEntity(postDto, user);
        postRepository.save(post);
        return post;
    }
    public Post postToEntity(PostDto postDto, User user){
        postDto.setNickname(user.getNickname());
        postDto.setUserId(user.getId());
        Post post = new Post(postDto);
        return post;
    }
}
