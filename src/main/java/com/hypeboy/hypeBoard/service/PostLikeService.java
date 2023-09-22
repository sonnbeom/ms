//package com.hypeboy.hypeBoard.service;
//
//import com.hypeboy.hypeBoard.entity.PostLike;
//import com.hypeboy.hypeBoard.repository.PostLikeRepository;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@Log4j2
//public class PostLikeService {
//    @Autowired
//    private PostLikeRepository likeRepository;
//
//    public void likeDeciding(Long postId, String userId) {
//        Optional<PostLike> postLike = likeRepository.findByPostIdAndUserId(postId, userId);
//        if (postLike.isPresent()){
//            likeRepository.deleteByPostIdAndUserId(postId, userId);;
//        }else {
//            likeRepository.save(new PostLike(postId, userId));
//        }
//    }
//}
