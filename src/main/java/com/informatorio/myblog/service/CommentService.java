package com.informatorio.myblog.service;

import com.informatorio.myblog.DTO.CommentDTO;
import com.informatorio.myblog.model.Comment;
import com.informatorio.myblog.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private CommentRepository commentRepository;

    public CommentDTO createComment(Comment c) {
        return new CommentDTO(commentRepository.save(c));
    }

    public List<CommentDTO> getComments() {
        return commentRepository.findAll().stream().map(CommentDTO::new).collect(Collectors.toList());
    }

    public Comment findComment(Long commentId) {

        return commentRepository.getOne(commentId);
    }

    public CommentDTO updateComment(Comment updateC) {
        return new CommentDTO(commentRepository.save(updateC));
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public List<Comment> getCommentsByPost(Long id, Integer num) {
        return commentRepository.CommentsByPostId(id, num);}

}
