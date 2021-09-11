package ua.com.nix.timeline_proj.service;

import ua.com.nix.timeline_proj.model.User;

public interface UserService {

    User saveUser(User user);

    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    User getUserById(Long id);

}
