package com.learning.digitalLibrary.service;

import com.learning.digitalLibrary.entity.BookEntity;
import com.learning.digitalLibrary.repository.impl.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity saveBookDetails(BookEntity bookEntity){
        return this.bookRepository.addBook(bookEntity);
    }

    public BookEntity findBookDetails(int id){
        return this.bookRepository.findBook(id);
    }

    public void deleteBookDetails(int id){
         this.bookRepository.deleteBook(id);
    }
}
