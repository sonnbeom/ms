package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;

import java.sql.SQLException;
import java.util.List;


public interface MemoryPostRepository {

    void save(Post post) throws SQLException;
    void deletePost(String id, int postId) throws SQLException;
    List<PostDto> findByNickname(String nickname, int contentCount);
    List<PostDto> findById(String id, int contentCount);
    void updatePost(PostDto postDto ,String id, int postId);


}
