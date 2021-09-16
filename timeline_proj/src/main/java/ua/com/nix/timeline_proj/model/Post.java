package ua.com.nix.timeline_proj.model;

import lombok.Data;

import javax.persistence.*;

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

    public Post(Long id, String content) {
        this.id = id;
        this.content = content;
    }

}
