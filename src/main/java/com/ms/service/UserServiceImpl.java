package com.ms.service;

import com.ms.dto.ResDto;
import com.ms.dto.UserReqDto;
import com.ms.dto.UserResDto;
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
    public ResDto<UserResDto> save(UserReqDto dto) {

        UserReqDto encryptedDto = encryptPassword(dto);
        User user = UserConverter.UserDtoToUser(encryptedDto);


        ResDto<UserResDto> result = new ResDto<>();
        try {
            User savedUser = userRepository.save(user);
            UserResDto resDto = UserConverter.UserToUserResDto(savedUser);
            result.setData(resDto);
        } catch (Exception ex) {
            log.error("/userservice/save: error >> " + ex);
            String message = ex.getMessage();
            result.setErrorMsg(message);
        }

        return result;
    }

    private UserReqDto encryptPassword(UserReqDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return dto;
    }
}
