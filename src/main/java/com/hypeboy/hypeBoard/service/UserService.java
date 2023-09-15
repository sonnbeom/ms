package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }
    public User Registration(User user){
        duplicateIdCheck(user);
        userRepository.save(user);
        return user;
    }
    private void duplicateIdCheck(User user) {
        userRepository.findById(user.getId()).
                ifPresent(u->{throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    public User toEntity(UserDto userDto){

        return new User(userDto);
    }

}