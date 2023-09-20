package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.entity.PostLike;
import com.hypeboy.hypeBoard.repository.PostLikeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PostLikeService {
    @Autowired
    private PostLikeRepository likeRepository;

    public PostLike likePost(Long postId, String userId) {
        Optional<PostLike> postLike = likeRepository.findByPostIdAndUserId(postId, userId);
        if (postLike.isEmpty()) {
            postLike = Optional.of(new PostLike());
        }
        postLike.get().setPostId(postId);
        postLike.get().setUserId(userId);
        likeRepository.save(postLike.get());
        return postLike.orElseThrow();
        //void 수정 필요
    }
}
