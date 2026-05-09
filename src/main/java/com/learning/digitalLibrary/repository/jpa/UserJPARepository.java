package com.learning.digitalLibrary.repository.jpa;

import com.learning.digitalLibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByEmail(String email);
}
