package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.Comment;
import com.informatorio.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/comment")
@RestController
public class CommentController {

    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment c){
        return new ResponseEntity<>(commentService.createComment(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getComment() {
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestBody Comment c){
        Comment updateC = commentService.findComment(commentId);
        updateC.setBodyComment(c.getBodyComment());
        return new ResponseEntity<>(commentService.updateComment(updateC), HttpStatus.OK);
    }

    @DeleteMapping ("/{commentId}")
    public ResponseEntity<?> deleteComment (@PathVariable Long commentId) {
        Comment comment = commentService.findComment(commentId);
        commentService.delete(comment);
        return new ResponseEntity<>(HttpStatus.OK); }


    @GetMapping("/post")
    public ResponseEntity<?> getCommentsByPost(@RequestParam Long postId, @RequestParam(required=false, defaultValue = "9999999") Integer num) {
        return new ResponseEntity<>(commentService.getCommentsByPost(postId, num), HttpStatus.OK); }
}