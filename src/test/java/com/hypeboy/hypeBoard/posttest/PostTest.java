package com.hypeboy.hypeBoard.posttest;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.PostRepository;
import com.hypeboy.hypeBoard.service.PostLikeService;
import com.hypeboy.hypeBoard.service.PostService;
import com.hypeboy.hypeBoard.service.ViewCounterService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Transactional

public class PostTest {
    @Autowired PostService postService;
    @Autowired PostRepository postRepository;
    @Autowired ViewCounterService viewCounterService;
    @Autowired
    PostLikeService postLikeService;

    @AfterEach
    public void setUp(){
        postRepository.deleteAll();
    }
    @Test
    public void postUploadTest(){

        User user = new User("son", "sonny", "123", "1234", "na@ver.com","beom" );
        PostDto postDto1 =new PostDto("fds", "dsa", "dsa");
        PostDto postDto2 =new PostDto("h2", "h2", "h2");
        Post testPost_1 = postService.postRegister(postDto1,user);
        Post testPost_2 = postService.postRegister(postDto2,user);
        Assertions.assertThat(testPost_1.getPostId()).isNotEqualTo(testPost_2.getPostId());
    }
    @Test
    public void viewCountTest(){
        PostDto postDto1 =new PostDto("h2", "hello", "love");
        User sonny = new User("son", "sonny", "123", "1234", "na@ver.com","beom" );
        Post post =  postService.postRegister(postDto1, sonny);
        Post post2 = viewCounterService.increaseViewCount(post.getPostId());
        System.out.println(post2.getViewCount());
        System.out.println(post2);
        System.out.println(2);
        Assertions.assertThat(post2.getViewCount()).isEqualTo(1);
    }

}
