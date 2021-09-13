package ua.com.nix.timeline_proj.service;

import org.springframework.security.core.Authentication;
import ua.com.nix.timeline_proj.model.Post;
import ua.com.nix.timeline_proj.model.User;

import java.util.List;

public interface PostService {

    Post getById(Long id);

    Post save(Post post);

    void delete(Long id);

    List<Post> getAll();

}
