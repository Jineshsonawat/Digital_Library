package com.learning.digitalLibrary.repository.impl;


import com.learning.digitalLibrary.entity.BookEntity;
import com.learning.digitalLibrary.repository.jpa.BookJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final BookJPARepository bookJPARepository;

    public BookRepository(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    public BookEntity addBook(BookEntity bookEntity){
        return this.bookJPARepository.save(bookEntity);
    }

    public BookEntity findBook(int id){
        return this.bookJPARepository.findById(id).orElse(null);
    }

    public void deleteBook(int id){
        this.bookJPARepository.deleteById(id);
    }

    public List<BookEntity> getAllBookDetails(){
        return this.bookJPARepository.findAll();
    }
}
