package com.learning.digitalLibrary.repository.impl;

import com.learning.digitalLibrary.dto.BookIssueDto;
import com.learning.digitalLibrary.entity.BookIssueEntity;
import com.learning.digitalLibrary.record.BookIssueCount;
import com.learning.digitalLibrary.repository.jpa.BookIssueJPARepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BookIssueRepository {

    private final BookIssueJPARepository bookIssueJPARepository;

    public BookIssueRepository(BookIssueJPARepository bookIssueJPARepository) {
        this.bookIssueJPARepository = bookIssueJPARepository;
    }

    public BookIssueEntity save(BookIssueEntity bookIssueEntity){
        return this.bookIssueJPARepository.save(bookIssueEntity);
    }

    public List<BookIssueEntity> issuedBookDetails(int userId)
    {
        return this.bookIssueJPARepository.getBookIssuedByUser(userId, LocalDate.now());
    }

    public List<BookIssueCount> getTopNIssuesBooks(int n){
        Pageable topN = PageRequest.of(0,n);
        return this.bookIssueJPARepository.findMostIssuedBooks(topN);
    }
}
