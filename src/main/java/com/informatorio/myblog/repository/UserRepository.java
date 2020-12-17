package com.informatorio.myblog.repository;

import com.informatorio.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    @Query("FROM User WHERE city LIKE 'Resistencia'")
    List <User> findUserByCity();

    @Query("FROM User WHERE singUpDate > ?1")
    List <User> findCreationDateAfter(LocalDate date);
}
