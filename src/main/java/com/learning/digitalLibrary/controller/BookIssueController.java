package com.learning.digitalLibrary.controller;

import com.learning.digitalLibrary.dto.BookIssueDto;
import com.learning.digitalLibrary.entity.BookIssueEntity;
import com.learning.digitalLibrary.mapper.dto.BookIssueDtoMapper;
import com.learning.digitalLibrary.service.BookIssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/book_issue")
public class BookIssueController {

    private final BookIssueService bookIssueService;
    private final BookIssueDtoMapper bookIssueDtoMapper;

    public BookIssueController(BookIssueService bookIssueService, BookIssueDtoMapper bookIssueDtoMapper) {
        this.bookIssueService = bookIssueService;
        this.bookIssueDtoMapper = bookIssueDtoMapper;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> saveIssueBook (@RequestBody BookIssueDto bookIssueDto){
        int userId = bookIssueDto.getUserId();
        BookIssueEntity bookIssueEntity = bookIssueDtoMapper.toEntity(bookIssueDto);
        try{
            BookIssueEntity bookIssued = bookIssueService.saveBookIssue(bookIssueEntity, userId);
            System.out.println("Book Issued : " + bookIssued.toString());
            return new ResponseEntity<>(bookIssued , HttpStatus.CREATED);
        }catch(IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
