package com.informatorio.myblog.service;

import com.informatorio.myblog.DTO.PostDTO;
import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO createPost(Post newPost) {
        return new PostDTO(postRepository.save(newPost));
    }

    public List<PostDTO> findAll() {
        return postRepository.findAll().stream().map(PostDTO::new).collect(Collectors.toList()); }

    public Post getPost(Long postId) { return postRepository.getOne(postId); }

    public PostDTO updatePost(Post updatePost) {
        return new PostDTO(postRepository.save(updatePost));
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public List<Post> getPostWithWord(String word) {
        return postRepository.findPost(word);
    }

    public List<Post> findNotPublished() {
        return postRepository.findNotPublished();
    }

}

