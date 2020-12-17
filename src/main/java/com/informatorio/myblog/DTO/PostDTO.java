package com.informatorio.myblog.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.informatorio.myblog.model.Comment;
import com.informatorio.myblog.model.Post;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private String body;
    private UserDTO userDto;
    private LocalDate dateCreated;
    private Boolean published;
    private List<CommentDTO> commentDto;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.body = post.getBody();
        this.userDto = new UserDTO(post.getUser());
        this.dateCreated = post.getDateCreated();
        this.published = post.getPublished();
        this.commentDto =  post.getComments().stream()
                .map((Comment commentDto)-> new CommentDTO(
                        commentDto.getId(),
                        commentDto.getBodyComment(),
                        commentDto.getDate())).collect(Collectors.toList());
    }

    public PostDTO(Long id, String title, String description, String body, UserDTO userDto, LocalDate dateCreated, Boolean published, List<CommentDTO> commentDTO) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.userDto = userDto;
        this.dateCreated = dateCreated;
        this.published = published;
        this.commentDto = commentDTO;
    }

    public PostDTO(Long id, String title, String description, String body, UserDTO userDto, LocalDate dateCreated, Boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.userDto = userDto;
        this.dateCreated = dateCreated;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public List<CommentDTO> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDTO> commentDto) {
        this.commentDto = commentDto;
    }

}
