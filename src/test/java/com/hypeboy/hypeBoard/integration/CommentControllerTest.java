package com.hypeboy.hypeBoard.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypeboy.hypeBoard.enums.EndPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test

    public void createComment_Return_Fail_InvalidDto() throws Exception {
        String body = "" +
                "postId=1" +
                "&userId=test1" +
                "&text=This is the test comment";

        ResultActions response = mockMvc.perform(post(EndPoint.Path.COMMENT)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content(body));

        response.andExpect(status().isOk())
                .andExpect(view().name(EndPoint.Path.COMMENT_FAIL));

    }

    @Test
    public void createComment_Return_Success() throws Exception {
        String body = "" +
                "postId=1" +
                "&userId=test1" +
                "&text=This is the test comment";

        ResultActions response = mockMvc.perform(post(EndPoint.Path.COMMENT)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content(body));

        response.andExpect(status().isOk())
                .andExpect(view().name(EndPoint.Path.COMMENT_SUCCESS));
    }

}
