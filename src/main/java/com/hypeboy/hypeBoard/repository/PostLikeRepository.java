package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByPostIdAndUserId(Long postId, String userId);
//    List<PostLike> findAllByPostId(Long postId);
//
//    List<PostLike> findAllByUserId(String userId);
//
//    PostLike save(PostLike postLike);
//
//    PostLike findByPostIdAndUserId(Long postId, String userId);
//
//    void deleteById(Long id);
}
