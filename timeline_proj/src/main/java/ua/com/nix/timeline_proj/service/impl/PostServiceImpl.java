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
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post getById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Post save(Post post) {
        post.setContent(post.getContent());
            return postRepository.save(post);
    }

    @Override
    public void delete(Long id, Authentication authentication) {

    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
