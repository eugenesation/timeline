package ua.com.nix.timeline_proj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.com.nix.timeline_proj.controller.request.AuthRequest;
import ua.com.nix.timeline_proj.model.Role;
import ua.com.nix.timeline_proj.model.User;
import ua.com.nix.timeline_proj.repository.RoleRepository;
import ua.com.nix.timeline_proj.repository.UserRepository;
import ua.com.nix.timeline_proj.service.UserService;
import ua.com.nix.timeline_proj.service.impl.UserServiceImpl;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository
    ) {
        this.userRepository = userRepository;
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
    public String updateUserLoginAndPassword(@RequestBody AuthRequest authRequest, @PathVariable Long id) {
        log.info("Starting update user...");
        User user = userRepository.getById(id);
        user.setLogin(authRequest.getLogin());
        user.setPassword(authRequest.getPassword());
        userRepository.save(user);
        user.setId(id);
        log.info("Ending update user...");
        return "UPDATED";
    }


}
