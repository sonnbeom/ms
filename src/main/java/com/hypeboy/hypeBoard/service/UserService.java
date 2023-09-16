package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public User join(String id, String pwd){
        User idUser = idJoin(id);
        List<User> pwdUser = pwdJoin(pwd);
        for (User user :pwdUser) {
            if (user.equals(idUser)){
                return user;
            }
        } throw new NoSuchElementException("사용자를 찾을 수 없습니다.");
    }
  
    public List<User> pwdJoin(String pwd){
        List<User> pwdCheck =  userRepository.findByPwd(pwd);
        if (pwdCheck.size()==0){
            throw new NoSuchElementException("비밀번호가 존재하지 않습니다.");
        }
        return pwdCheck;
    }
  
    public User idJoin(String id){
        return userRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("아이디가 존재하지 않습니다."));
    }

    private void encryptPassword(UserDto dto) {
        dto.setPwd(passwordEncoder.encode(dto.getPwd()));
    }



}