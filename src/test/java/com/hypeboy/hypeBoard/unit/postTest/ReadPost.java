package com.hypeboy.hypeBoard.unit.postTest;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.page.Page;
import com.hypeboy.hypeBoard.repository.PostRepository;
import com.hypeboy.hypeBoard.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class ReadPost {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Test
    void readPostTest() throws SQLException {
        //given
        PostDto postDto1 = new PostDto("testTitle1", "fun", "test1");
        Post testPost1 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost2 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost3 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost4 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost5 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost6 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost7 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost8 = postService.postRegister(postDto1, "testId", "testNickname");
        Post testPost9=  postService.postRegister(postDto1, "testId", "testNickname");

        //when
        // by id
        Page<PostDto> page1 = postService.createPageById("testId", 1);
        Page<PostDto> page2 = postService.createPageById("testId", 2);

        List<PostDto> cotentList = page1.getContent();
        List<PostDto> contentList2 = page2.getContent();

        //by nickname

        Page<PostDto> pageByNickName1 = postService.createPageByNickName("testNickName", 1);
        Page<PostDto> pageByNickName2 = postService.createPageByNickName("testNickName", 2);

        List<PostDto> contentListByNickname1 =  pageByNickName1.getContent();
        List<PostDto> contentListByNickname2 =  pageByNickName2.getContent();


        //then
        //by id
        Assertions.assertThat( cotentList.size()).isEqualTo(5);
        Assertions.assertThat( contentList2.size()).isEqualTo(5);
        Assertions.assertThat(page1.getCurrentPage()).isEqualTo(1);
        Assertions.assertThat(page2.getCurrentPage()).isEqualTo(2);

        //by nickname

        Assertions.assertThat( contentListByNickname1.size()).isEqualTo(5);
        Assertions.assertThat( contentListByNickname2.size()).isEqualTo(5);
        Assertions.assertThat(pageByNickName1.getCurrentPage()).isEqualTo(1);
        Assertions.assertThat(pageByNickName2.getCurrentPage()).isEqualTo(2);





    }
}
