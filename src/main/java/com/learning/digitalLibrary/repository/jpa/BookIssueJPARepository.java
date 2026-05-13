package com.learning.digitalLibrary.repository.jpa;


import com.learning.digitalLibrary.entity.BookIssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookIssueJPARepository extends JpaRepository<BookIssueEntity, Integer> {

    @Query("SELECT b FROM BookIssueEntity b WHERE b.userEntity.id = :userId AND b.expiryDate > :today")
    List<BookIssueEntity> getBookIssuedByUser(@Param("userId") int userId,
                                              @Param("today") LocalDate today);

}
