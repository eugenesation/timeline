package ua.com.nix.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.nix.timeline.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    List<User> findAllByRoleName(String roleName);

    void deleteUserById(Long id);

}
