package ua.com.nix.timeline_proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.com.nix.timeline_proj.controller.request.AuthRequest;
import ua.com.nix.timeline_proj.model.User;
import ua.com.nix.timeline_proj.repository.UserRepository;
import ua.com.nix.timeline_proj.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, UserServiceImpl userServiceImpl, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userServiceImpl = userServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/get/admins")
    public List<User> getAdmins() {
        return userRepository.findAllByRoleName("ROLE_ADMIN");
    }

    @GetMapping("/user/get/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @DeleteMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        log.info("Starting delete...");

        userRepository.deleteUserById(id);

        log.info("Ending delete...");
        return "DELETED";
    }

    @PutMapping("/user/update/{id}")
    public String updateUserLoginAndPasswordById(@RequestBody AuthRequest authRequest, @PathVariable Long id) {
        log.info("Starting update user...");

        User user = userServiceImpl.getUserById(id);
        user.setLogin(authRequest.getLogin());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        userServiceImpl.saveUser(user);
        user.setId(id);

        log.info("Ending update user...");
        return "UPDATED";
    }


}
