package org.learnspringframework.restfullwebservices.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table( name = "Posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_caption")
    private String postCaption;

    @Column(name = "post_created_date")
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserJpa user;

    public Posts(Long id, String postTitle, String postCaption, LocalDateTime createdTime) {
        this.id = id;
        this.postTitle = postTitle;
        this.postCaption = postCaption;
        this.createdTime = createdTime;
    }

    public Posts() {

    }

    public UserJpa getUser() {
        return user;
    }

    public void setUser(UserJpa user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostCaption() {
        return postCaption;
    }

    public void setPostCaption(String postCaption) {
        this.postCaption = postCaption;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
