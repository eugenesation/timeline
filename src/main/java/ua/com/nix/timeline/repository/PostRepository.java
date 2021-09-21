package ua.com.nix.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
