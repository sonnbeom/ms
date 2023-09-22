package com.hypeboy.hypeBoard.posttest;

import com.hypeboy.hypeBoard.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class PostTest {
    @Autowired PostService postService;

    @Test
    public void postUploadTest(){

     //   User user = new User("son", "sonny", "123", "1234","na@ver.com","beom" );
//        PostDto postDto1 =new PostDto("fds", "dsa", "dsa");
//        PostDto postDto2 =new PostDto("h2", "h2", "h2");
//        Post testPost_1 = postService.postRegister(postDto1,"son","sonny");
//        Post testPost_2 = postService.postRegister(postDto2,"son","sonny");
//        Assertions.assertThat(testPost_1.getId()).isNotEqualTo(testPost_2.getId());
//        Assertions.assertThat(testPost_1.getUserId()).isEqualTo(testPost_2.getUserId());
//        Assertions.assertThat(testPost_1.getNickname()).isEqualTo(testPost_2.getNickname());
    }


}
