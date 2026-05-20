package com.learning.digitalLibrary.mapper.dto;


import com.learning.digitalLibrary.dto.BookIssueDto;
import com.learning.digitalLibrary.entity.BookEntity;
import com.learning.digitalLibrary.entity.BookIssueEntity;
import com.learning.digitalLibrary.entity.UserEntity;
import com.learning.digitalLibrary.repository.impl.BookRepository;
import com.learning.digitalLibrary.repository.impl.UserRepository;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.time.LocalDate;

@Component
public class BookIssueDtoMapper {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BookIssueDtoMapper(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public BookIssueEntity toEntity(BookIssueDto bookIssueDto){
        UserEntity userEntity = this.userRepository.getById(bookIssueDto.getUserId());
        BookEntity bookEntity = this.bookRepository.findBook(bookIssueDto.getBookId());
        LocalDate issueDate = bookIssueDto.getIssueDate();
        LocalDate expiryDate = bookIssueDto.getIssueDate().plusDays(14);
        return BookIssueEntity.builder()
                .userEntity(userEntity)
                .bookEntity(bookEntity)
                .issueDate(issueDate)
                .expiryDate(expiryDate)
                .build();
    }
}
