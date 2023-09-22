package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryPostRepository {

    void save(Post post);

}
