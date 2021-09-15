package ua.com.nix.timeline_proj.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.com.nix.timeline_proj.TimelineProjApplication;
import ua.com.nix.timeline_proj.controller.request.PostRequest;
import ua.com.nix.timeline_proj.model.Post;
import ua.com.nix.timeline_proj.repository.PostRepository;
import ua.com.nix.timeline_proj.service.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostControllerTest {

    private MockMvc mockMvc;

    private PostServiceImpl postService;

    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postService = mock(PostServiceImpl.class);
        postRepository = mock(PostRepository.class);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new PostController(postRepository, postService))
                .build();
    }

//    @Test
//    void createPost() throws Exception {
//        var request = new PostRequest();
//        request.setContent("text");
//
//
//    }

    @Test
    void getAllPosts() throws Exception {
        when(postRepository.findAll()).thenReturn(Arrays.asList(
                new Post(1L, "Rap"),
                new Post(2L, "Content")
        ));

        mockMvc.perform(get("/get"));
    }

//    @Test
//    void delete() throws Exception {
//        List<Post> posts = new ArrayList<>();
//        Post post = new Post(1L);
//        posts.add(post);
//
//        postService.delete(post.getId());
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/content/delete/{id}"))
//                .andExpect(status().isNotFound());
//
//        Assertions.assertFalse(post.getId() == 1);
//
//
//
//    }

    @Test
    void updatePostById() {
    }
}