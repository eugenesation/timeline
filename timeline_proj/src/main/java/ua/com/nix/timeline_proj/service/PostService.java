package ua.com.nix.timeline_proj.service;

import ua.com.nix.timeline_proj.model.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    void delete(Long id);

    List<Post> getAll();

}
