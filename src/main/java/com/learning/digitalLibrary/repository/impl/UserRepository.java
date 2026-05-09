package com.learning.digitalLibrary.repository.impl;

import com.learning.digitalLibrary.entity.UserEntity;
import com.learning.digitalLibrary.repository.jpa.UserJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final UserJPARepository userJPARepository;

    public UserRepository(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public UserEntity getById(int id){
        return this.userJPARepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity userEntity){
        return this.userJPARepository.save(userEntity);
    }

    public Boolean checkIfEmailExist(String email){
        return this.userJPARepository.existsByEmail(email);
    }
}
