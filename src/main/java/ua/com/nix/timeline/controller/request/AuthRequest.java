package ua.com.nix.timeline.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthRequest {

    @NotBlank
    private String login;
    @NotBlank
    private String password;

}
