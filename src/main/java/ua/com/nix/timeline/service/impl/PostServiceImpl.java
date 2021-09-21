package ua.com.nix.timeline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.nix.timeline.model.Post;
import ua.com.nix.timeline.repository.PostRepository;
import ua.com.nix.timeline.service.PostService;

import java.util.List;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        if (post != null) {
            postRepository.save(post);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            postRepository.deleteById(id);
        }
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

}
