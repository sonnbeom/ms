package com.ms.service;


import com.ms.dto.ResDto;
import com.ms.dto.UserReqDto;
import com.ms.dto.UserResDto;

public interface UserService {
    ResDto<UserResDto> save(UserReqDto user);
}