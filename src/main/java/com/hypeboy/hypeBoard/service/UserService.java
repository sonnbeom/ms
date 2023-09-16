package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(UserDto userDto){
        encryptPassword(userDto);
        User user = toEntity(userDto);
        duplicateIdCheck(user);
        duplicateEmailCheck(user);
        // insert 먼저 혹 select 먼저 작성 필요
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
    private void duplicateEmailCheck(User user){
        userRepository.findByEmail(user.getEmail()).
                ifPresent(u->{throw new IllegalStateException("중복된 이메일입니다.");});
    }

    private void encryptPassword(UserDto dto) {
        dto.setPwd(passwordEncoder.encode(dto.getPwd()));
    }



}