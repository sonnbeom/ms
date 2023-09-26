//package com.hypeboy.hypeBoard.controller;
//
//import com.hypeboy.hypeBoard.dto.UserDto;
//import com.hypeboy.hypeBoard.entity.User;
//import com.hypeboy.hypeBoard.entity.UserDetailsCustom;
//import com.hypeboy.hypeBoard.enums.EndPoint;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping(EndPoint.Path.SIGNUP)
//    public String signup() {
//        return "registration";
//    }
//
//    @PostMapping(EndPoint.Path.SIGNUP_RESULT)
//
//    public String createUser(@ModelAttribute UserDto userDto) {
//        userService.register(userDto);
//        return "regicomplete";
//    }
//
//    @GetMapping(EndPoint.Path.LOGIN)
//    public String callLoginPage() {
//        return "login";
//    }
//
//
//    @GetMapping(EndPoint.Path.LOGIN_RESULT)
//    public String contentSample(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = ((UserDetailsCustom) auth.getPrincipal()).getUser();
//
//        model.addAttribute("user", user);
//        return "content";
//    }
//}
