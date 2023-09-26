package com.hypeboy.hypeBoard.unit.postTest;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.repository.PostRepository;
import com.hypeboy.hypeBoard.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class deletePost {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Test
    void deletePostTest() throws SQLException {
        //given
        PostDto postDto = new PostDto("testTitle","testContent","testCategory" );
        Post testPost1 = postService.postRegister(postDto, "testId1", "testNickname");
        Post testPost2 = postService.postRegister(postDto, "testId2", "testNickname");

        //when
        postService.delete("testId1", 1);


    }
}
