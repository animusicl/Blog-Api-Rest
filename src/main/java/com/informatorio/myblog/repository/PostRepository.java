package com.informatorio.myblog.repository;

import com.informatorio.myblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE %:word%")
    List <Post> findPost(@Param("word") String word);

    @Query("SELECT p FROM Post p WHERE p.published = 0")
    List <Post> findNotPublished();

}
