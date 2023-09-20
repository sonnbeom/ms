package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post save(Post post);
    void deleteById(Long id);
}
