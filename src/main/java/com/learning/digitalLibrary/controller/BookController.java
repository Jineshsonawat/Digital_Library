package com.learning.digitalLibrary.controller;

import com.learning.digitalLibrary.entity.BookEntity;
import com.learning.digitalLibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id){
        BookEntity book = this.bookService.findBookDetails(id);
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> saveBookDetails(@RequestBody BookEntity bookEntity){
        BookEntity book = this.bookService.saveBookDetails(bookEntity);
        return new ResponseEntity<>(book , HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteBookById(@PathVariable int id){
        this.bookService.deleteBookDetails(id);
        return new ResponseEntity<>("Deleted Successfully" , HttpStatus.OK);
    }
}
