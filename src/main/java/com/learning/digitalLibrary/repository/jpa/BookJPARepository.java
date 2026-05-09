package com.learning.digitalLibrary.repository.jpa;

import com.learning.digitalLibrary.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<BookEntity, Integer> {
}
