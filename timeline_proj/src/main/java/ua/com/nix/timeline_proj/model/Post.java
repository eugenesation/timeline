package ua.com.nix.timeline_proj.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Post(String content) {
        this.content = content;
    }

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
    }
}
