package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String createUser(@ModelAttribute UserDto userDto){
        userService.Registration(userDto);
        return "regicomplete";
    }
    @GetMapping("signup")
    public String signup(){
        return "registration";
    }
}