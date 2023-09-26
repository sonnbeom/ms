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
public class UpdatePost {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;
    @Test
    void updatePostTest() throws SQLException {
        //given
        PostDto postDto = new PostDto("testTitle","testContent","testCategory" );
        Post testPost1 = postService.postRegister(postDto, "testId1", "testNickname");
        Post testPost2 = postService.postRegister(postDto, "testId2", "testNickname");
        Post testPost3 = postService.postRegister(postDto, "testId3", "testNickname");
        Post testPost4 = postService.postRegister(postDto, "testId4", "testNickname");
        Post testPost5 = postService.postRegister(postDto, "testId5", "testNickname");
        Post testPost6 = postService.postRegister(postDto, "testId6", "testNickname");

        PostDto testPostDto = new PostDto("testTitleUpdate","testContentUpdate","testCategoryUpdate" );
        PostDto testPostDto2 = new PostDto("testTitleUpdate","testContentUpdate","testCategoryUpdate" );
        PostDto testPostDtoTitleEx = new PostDto(null,"testContentUpdate","testCategoryUpdate" );
        PostDto testPostDtoCategoryEx = new PostDto("testTitleUpdate","testContentUpdate",null);
        PostDto testPostDtoOnlyContent = new PostDto(null,"testContentUpdate",null);

        //when
        postService.updatePost(testPostDto, "testId1", 1);
        postService.updatePost(testPostDto2, "testId2", 2);
        postService.updatePost(testPostDtoTitleEx,"testId3",3);
        postService.updatePost(testPostDtoCategoryEx,"testId4",4);
        postService.updatePost(testPostDtoOnlyContent,"testId5",5);

        //then




    }
}
