package ua.com.nix.timeline_proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.nix.timeline_proj.controller.request.PostRequest;
import ua.com.nix.timeline_proj.model.Post;
import ua.com.nix.timeline_proj.repository.PostRepository;
import ua.com.nix.timeline_proj.service.impl.PostServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/content")
@Slf4j
public class PostController {

    private final PostRepository postRepository;
    private final PostServiceImpl postServiceImpl;

    @Autowired
    public PostController(PostRepository postRepository, PostServiceImpl postServiceImpl) {
        this.postRepository = postRepository;
        this.postServiceImpl = postServiceImpl;
    }

    @PostMapping("/add")
    public String createPost(@RequestBody @Valid PostRequest postRequest) {
        Post post = new Post();
        post.setContent(postRequest.getContent());
        postServiceImpl.save(post);
        return "OK";
    }

    @GetMapping("/get")
    public List<Post> getAllPosts() {
        return postServiceImpl.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id) {
        postServiceImpl.delete(id);
        return "DELETED";
    }

    @PutMapping("/update/{id}")
    public String updatePostById(@RequestBody @Valid PostRequest postRequest, @PathVariable Long id) {
        log.info("Starting update...");

        Post post = postRepository.getById(id);
        post.setContent(postRequest.getContent());
        postRepository.save(post);
        post.setId(id);

        log.info("Ending update...");
        return "UPDATED";
    }

}
