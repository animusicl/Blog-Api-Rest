package com.informatorio.myblog.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.informatorio.myblog.model.Comment;
import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Long Id;
    private String bodyComment;
    private LocalDate date;

    public CommentDTO(Long id) {
        Id = id;
    }

    public CommentDTO(Comment comment) {
        this.Id = comment.getId();
        this.bodyComment = comment.getBodyComment();
    }

    public CommentDTO(Long id, String bodyComment, LocalDate date) {
        this.Id = id;
        this.bodyComment = bodyComment;
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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