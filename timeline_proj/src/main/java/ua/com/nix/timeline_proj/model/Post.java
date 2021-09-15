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

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;

}
