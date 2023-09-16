package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
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

}