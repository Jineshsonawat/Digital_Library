package com.learning.digitalLibrary.service;

import com.learning.digitalLibrary.entity.UserEntity;
import com.learning.digitalLibrary.repository.impl.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUserToDb(UserEntity userEntity){
        if(userRepository.checkIfEmailExist(userEntity.getEmail())){
            throw new IllegalArgumentException("Email Already Exist");
        }
        return this.userRepository.save(userEntity);
    }
}
