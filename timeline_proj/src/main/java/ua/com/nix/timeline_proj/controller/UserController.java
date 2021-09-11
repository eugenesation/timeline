package ua.com.nix.timeline_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.nix.timeline_proj.model.User;
import ua.com.nix.timeline_proj.repository.UserRepository;
import ua.com.nix.timeline_proj.service.UserService;
import ua.com.nix.timeline_proj.service.impl.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }


    @GetMapping("/user/get/{id}")
    public List<User> getUser(@PathVariable Long id){
        return userRepository.getUsersById(id);
    }

}
