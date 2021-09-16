package ua.com.nix.timeline_proj.service;

import ua.com.nix.timeline_proj.model.User;

public interface UserService {

    void saveUser(User user);

    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    User getUserById(Long id);

    void saveAdmin(User user);

}
