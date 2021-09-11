package ua.com.nix.timeline_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline_proj.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    List<User> getUsersById(Long id);



}
