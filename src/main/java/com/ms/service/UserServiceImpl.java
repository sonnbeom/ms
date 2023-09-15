package com.ms.service;

import com.ms.dto.UserDto;
import com.ms.model.User;
import com.ms.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto dto) {

        UserDto encryptedDto = encryptPassword(dto);
        User user = UserConverter.fromUserDto(encryptedDto);

//      userRepository.save(user);
    }

    private UserDto encryptPassword(UserDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return dto;
    }
}
