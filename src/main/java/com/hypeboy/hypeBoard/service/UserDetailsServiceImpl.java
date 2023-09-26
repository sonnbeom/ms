//package com.hypeboy.hypeBoard.service;
//
//import com.hypeboy.hypeBoard.entity.User;
//import com.hypeboy.hypeBoard.entity.UserDetailsCustom;
//import com.hypeboy.hypeBoard.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findById(userId);
//        return user
//                .map(u -> new UserDetailsCustom(u))
//                .orElseThrow(() -> {
//                    throw new UsernameNotFoundException("아이디가 " + userId + "인 회원을 찾을 수 없습니다.");
//                });
//    }
//}
