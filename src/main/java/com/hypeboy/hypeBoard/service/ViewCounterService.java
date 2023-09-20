package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.repository.PostRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Log4j2
@Service
public class ViewCounterService {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    public Post increaseViewCount(Long postId){
        Post post = findPost(postId);
        post.setViewCount(post.getViewCount()+1);
        postRepository.save(post);
        return post;
// void로 수정 필
    }
    private Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with ID"));
    }


}
