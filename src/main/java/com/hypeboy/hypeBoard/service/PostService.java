package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post postRegister(PostDto postDto, String id, String nickname){
        Post post = postToEntity(postDto, id, nickname);
        log.info("check post {}", post.toString());
        postRepository.save(post);
        return post;
    }
    public Post postToEntity(PostDto postDto, String id, String nickname){
        postDto.setNickname(nickname);
        postDto.setUserId(id);
        Post post = new Post(postDto);
        return post;
    }
}
