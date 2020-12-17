package com.informatorio.myblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    @JsonBackReference(value="commentPost")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference(value="commentUser")
    private User user_comments;

    @NotBlank
    @Size(max = 200)
    private String bodyComment;
    private LocalDate date = LocalDate.now();

 //--------------------------------methods------------------------------------------------
    public Comment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public User getUser_comments() {
        return user_comments;
    }

    public void setUser_comments(User user_comments) {
        this.user_comments = user_comments;
    }

    public String getBodyComment() {
        return bodyComment;
    }

    public void setBodyComment(String bodyComment) {
        this.bodyComment = bodyComment;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }
}