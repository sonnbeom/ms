package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("result")
    public String createUser(UserDto userDto){
        User user = userService.toEntity(userDto);
        userService.Registration(user);
        return "regicomplete";
    }
    @GetMapping("signup")
    public String signup(){
        return "registration";
    }
}
