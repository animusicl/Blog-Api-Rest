package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postService;
    public PostController(PostService postService) { this.postService = postService; }

    @PostMapping
    public ResponseEntity<?> createPost (@RequestBody Post newPost) {
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.CREATED); }

    @GetMapping
    public ResponseEntity<?> getPost() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK); }

    @GetMapping("/")
    public ResponseEntity<?> getPostWithWord(@RequestParam String word){
        return new ResponseEntity<>(postService.getPostWithWord(word), HttpStatus.OK); }

    @GetMapping("/published")
    public ResponseEntity<?> notPublished(){
        return new ResponseEntity<>(postService.findNotPublished(), HttpStatus.OK); }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost (@PathVariable Long postId, @RequestBody Post post){
        Post updatePost = postService.getPost(postId);
        updatePost.setTitle(post.getTitle());
        updatePost.setDescription(post.getDescription());
        updatePost.setBody(post.getBody());
        updatePost.setPublished(post.getPublished());
        return new ResponseEntity<>(postService.updatePost(updatePost), HttpStatus.OK);
    }

    @DeleteMapping ("/{postId}")
    public ResponseEntity<?> deletePost (@PathVariable Long postId) {
        Post post = postService.getPost(postId);
        postService.delete(post);
        return new ResponseEntity<>(HttpStatus.OK); }


}
