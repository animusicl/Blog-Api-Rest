package com.informatorio.myblog.repository;

import com.informatorio.myblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value="SELECT * FROM Comment c WHERE post_id = ?1 LIMIT ?2", nativeQuery = true)
    List<Comment> CommentsByPostId(Long post_id, Integer num);

}


