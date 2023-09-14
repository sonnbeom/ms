package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
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
    private void duplicateEmailCheck(User user){

    }
//    public User userJoin(String id, String pwd) {
//        User pwdUser = pwdJoin(pwd);
//        Optional<User> checkId = userRepository.findById(id);
//
//        if (checkId.isPresent()) {
//            User user = checkId.get();
//            if (user.equals(pwdUser)) {
//                return user;
//            } else {
//                return null; // 또
//            }
//        } else {
//            throw new NoSuchElementException("아이디가 틀렸습니다.");
//        }
//    }
    public User userJoin(String id, String pwd){
        User checkPwd = pwdJoin(pwd);
        Optional<User> checkId = userRepository.findById(id);
        return checkId.filter(user -> user.equals(checkPwd))
                .orElseThrow(()->new NoSuchElementException("아이디가 틀렸습니다."));
    }


    public User pwdJoin(String pwd) {
        Optional<User> checkPwd =userRepository.findByPwd(pwd);
        if (checkPwd.isPresent()){
            return checkPwd.get();
        }else {
            throw new NoSuchElementException("비밀번호가 틀렸습니다.");
        }
    }
}



