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
//    public Post building(PostDto postDto){
//        return Post.builder()
//                .category(postDto.getCategory())
//                .title(postDto.getTitle())
//                .textContent(postDto.getTextContent())
//                .userId(postDto.getUserId())
//                .nickname(postDto.getNickname()).build();
//    }
    public Post postFindById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(()->new IllegalStateException("찾을 수 없는 포스트입니다."));
    }
    public Post postToEntity(PostDto postDto, User user){
        postDto.setNickname(user.getNickname());
        postDto.setUserId(user.getId());
        Post post = new Post(postDto);
        return post;
    }
}
