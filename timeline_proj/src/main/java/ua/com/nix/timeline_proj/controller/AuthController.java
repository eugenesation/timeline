package ua.com.nix.timeline_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.com.nix.timeline_proj.config.jwt.JwtProvider;
import ua.com.nix.timeline_proj.controller.request.AuthRequest;
import ua.com.nix.timeline_proj.controller.request.RegistrationRequest;
import ua.com.nix.timeline_proj.controller.response.AuthResponse;
import ua.com.nix.timeline_proj.model.User;
import ua.com.nix.timeline_proj.service.UserService;
import ua.com.nix.timeline_proj.service.impl.UserServiceImpl;

import javax.validation.Valid;

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
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userServiceImpl.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userServiceImpl.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }

}
