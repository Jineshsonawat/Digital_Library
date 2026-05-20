package com.learning.digitalLibrary.repository.jpa;


import com.learning.digitalLibrary.entity.BookIssueEntity;
import com.learning.digitalLibrary.record.BookIssueCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookIssueJPARepository extends JpaRepository<BookIssueEntity, Integer> {

    @Query("SELECT b FROM BookIssueEntity b WHERE b.userEntity.id = :userId AND b.expiryDate > :today")
    List<BookIssueEntity> getBookIssuedByUser(@Param("userId") int userId,
                                              @Param("today") LocalDate today);


    @Query("""
            SELECT b.bookEntity AS book, COUNT(b.id) AS issueCount
            FROM BookIssueEntity b
            GROUP BY b.bookEntity
            ORDER BY COUNT(b.id) DESC
           """)
    List<BookIssueCount> findMostIssuedBooks(Pageable pageable);

}
