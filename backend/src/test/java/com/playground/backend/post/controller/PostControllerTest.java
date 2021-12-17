package com.playground.backend.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.playground.backend.post.domain.Post;
import com.playground.backend.post.service.PostService;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getPosts메소드는_200을리턴한다() throws Exception {
        // given
        List<Post> postList = List.of(
                new Post(1L, "포스트 내용"),
                new Post(2L, "두 번째 내용")
        );
        given(postService.getPosts()).willReturn(postList);

        String posts = objectMapper.writeValueAsString(postList);

        // when
        ResultActions perform = mockMvc.perform(get("/posts"));

        // then
        perform.andExpect(status().isOk())
                .andExpect(content().string(posts));
    }

    @Test
    public void createPost메소드는_상품등록후_201을리턴한다() throws Exception {
        // given
        String contents = anyString();
        given(postService.createPost(contents)).willReturn(new Post(1L, contents));

        // when
        ResultActions perform = mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Post(1L, contents))));

        // then
        perform.andExpect(status().isCreated())
                .andExpect(content().string(containsString(contents)));

    }

}
