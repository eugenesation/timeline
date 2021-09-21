package ua.com.nix.timeline.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.com.nix.timeline.model.Post;
import ua.com.nix.timeline.repository.PostRepository;
import ua.com.nix.timeline.service.impl.PostServiceImpl;

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
        Post post = new Post(1L, "text");
        postRepository.save(post);
        List<Post> posts = postRepository.findAll();
        posts.add(post);
        mockMvc.perform(get("/get"))
                .andExpect(status().isNotFound());
    }

    @Test
    void delete() throws Exception {
        Post post = new Post(1L, "text");
        postRepository.save(post);





    }

    @Test
    void updatePostById() {
    }
}