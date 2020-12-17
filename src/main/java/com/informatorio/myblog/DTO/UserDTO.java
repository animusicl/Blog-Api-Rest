package com.informatorio.myblog.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.informatorio.myblog.model.Comment;
import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.model.User;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate singUpDate;
    private String country;
    private String state;
    private String city;
    private List<PostDTO> postDto;
    private List<CommentDTO> commentDto;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.singUpDate = user.getSingUpDate();
        this.country = user.getCountry();
        this.state = user.getState();
        this.city = user.getCity();
        this.postDto = retrievePosts(user);
        this.commentDto = user.getComments().stream()
                .map((Comment commentDto) -> new CommentDTO(
                        commentDto.getId(),
                        commentDto.getBodyComment(), commentDto.getDate()))
                .collect(Collectors.toList());
    }

    private List<PostDTO> retrievePosts(User user) {
        return user.getPosts().stream()
                .map((Post postDto) -> new PostDTO(
                        postDto.getId(),
                        postDto.getTitle(),
                        postDto.getDescription(),
                        postDto.getBody(),
                        new UserDTO(
                                postDto.getUser().getId()),
                        postDto.getDateCreated(),
                        postDto.getPublished(),
                        postDto.getComments().stream()
                                .map(CommentDTO::new)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public UserDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSingUpDate() {
        return singUpDate;
    }

    public void setSingUpDate(LocalDate singUpDate) {
        this.singUpDate = singUpDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<PostDTO> getPostDto() {
        return postDto;
    }

    public void setPostDto(List<PostDTO> postDto) {
        this.postDto = postDto;
    }

    public List<CommentDTO> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDTO> commentDto) {
        this.commentDto = commentDto;
    }
}
