package com.hypeboy.hypeBoard.unit.postTest;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.repository.PostRepository;
import com.hypeboy.hypeBoard.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class UploadPost {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Test
    void createPost() throws SQLException {
        //given
        PostDto postDto1 = new PostDto("testTitle1", "fun", "test1");
        PostDto postDto2 = new PostDto("testTitle2", "fun", "test2");
        //when
        Post testPost1 =  postService.postRegister(postDto1, "testId1", "testNickname");
        Post testPost2 =  postService.postRegister(postDto2, "testId2", "testNickname2");
        //then
        Assertions.assertThat(testPost1.getTextContent()).isEqualTo(testPost2.getTextContent());
        Assertions.assertThat(testPost1.getUserId()).isNotEqualTo(testPost2.getUserId());

    }
}
