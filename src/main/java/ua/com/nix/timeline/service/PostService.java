package ua.com.nix.timeline.service;

import ua.com.nix.timeline.model.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    void delete(Long id);

    List<Post> getAll();

}
