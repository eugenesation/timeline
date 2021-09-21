package ua.com.nix.timeline.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.nix.timeline.config.jwt.JwtProvider;
import ua.com.nix.timeline.controller.request.AuthRequest;
import ua.com.nix.timeline.controller.request.RegistrationRequest;
import ua.com.nix.timeline.controller.response.AuthResponse;
import ua.com.nix.timeline.model.User;
import ua.com.nix.timeline.service.impl.UserServiceImpl;

import javax.validation.Valid;

@Slf4j
@RestController
public class AuthController {

    private final UserServiceImpl userServiceImpl;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl, JwtProvider jwtProvider) {
        this.userServiceImpl = userServiceImpl;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        log.info("Starting registration user...");
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userServiceImpl.saveUser(u);
        log.info("Ending registration user...");
        return "User registered";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userServiceImpl.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }

    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody @Valid RegistrationRequest registrationRequest) {
        log.info("Starting registration admin...");
        User admin = new User();
        admin.setPassword(registrationRequest.getPassword());
        admin.setLogin(registrationRequest.getLogin());
        userServiceImpl.saveAdmin(admin);
        log.info("Ending registration admin...");
        return "Admin registered";
    }

}
