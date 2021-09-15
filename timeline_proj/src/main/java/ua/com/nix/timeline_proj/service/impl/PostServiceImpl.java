package ua.com.nix.timeline_proj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.nix.timeline_proj.model.Post;
import ua.com.nix.timeline_proj.model.User;
import ua.com.nix.timeline_proj.repository.PostRepository;
import ua.com.nix.timeline_proj.repository.UserRepository;
import ua.com.nix.timeline_proj.service.PostService;

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
    public Post getById(Long id) {
        if (id != null) {
            return postRepository.getById(id);
        }
        return null;
    }

    @Override
    public Post save(Post post) {
        if (post != null) {
            return postRepository.save(post);
        }
        return null;
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
