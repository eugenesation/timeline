package ua.com.nix.timeline_proj.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostRequest {

    @NotBlank
    private String content;

}
