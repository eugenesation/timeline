package ua.com.nix.timeline_proj.controller.request;

import lombok.Data;

@Data
public class AuthRequest {

    private String login;
    private String password;

}
