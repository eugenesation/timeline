package ua.com.nix.timeline_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline_proj.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
