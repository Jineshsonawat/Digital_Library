package com.learning.digitalLibrary.service;

import com.learning.digitalLibrary.entity.BookEntity;
import com.learning.digitalLibrary.entity.BookIssueEntity;
import com.learning.digitalLibrary.entity.UserEntity;
import com.learning.digitalLibrary.record.BookIssueCount;
import com.learning.digitalLibrary.repository.impl.BookIssueRepository;
import com.learning.digitalLibrary.repository.impl.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookIssueService {

    private final BookIssueRepository bookIssueRepository;
    private final UserRepository userRepository;

    public BookIssueService(BookIssueRepository bookIssueRepository, UserRepository userRepository) {
        this.bookIssueRepository = bookIssueRepository;
        this.userRepository = userRepository;
    }

    public BookIssueEntity saveBookIssue(BookIssueEntity bookIssueEntity, int userId){
        if(isUserCanIssueBook(userId)){
            return this.bookIssueRepository.save(bookIssueEntity);
        }
        throw new IllegalArgumentException("Subscription Limit Reached");

    }

    public List<BookIssueCount> getMostIssuesBooks(int n){
       return this.bookIssueRepository.getTopNIssuesBooks(n);
    }

    public List<BookEntity> getAllActiveBookIssuedByUser(int userId){
        List<BookEntity> bookEntity = this.bookIssueRepository.issuedBookDetails(userId)
                .stream()
                .map(BookIssueEntity::getBookEntity)
                .toList();

        return bookEntity;
    }

    public boolean isUserCanIssueBook(int userId){
        UserEntity userEntity = this.userRepository.getById(userId);

        int activeCount = bookIssueRepository.issuedBookDetails(userId).size();
        int allowance = userEntity.getSubscriptionType().getAllowance();

        return activeCount < allowance;
    }

}
