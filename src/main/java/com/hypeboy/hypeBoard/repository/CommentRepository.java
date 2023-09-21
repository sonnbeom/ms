package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // suggestion: post entity의 id를 postId에서 id로 변경하는건 어떨까요?
    Optional<Comment> findByPost_postId(Long postId);

}
