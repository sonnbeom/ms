package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.entity.UserDetailsCustom;
import com.hypeboy.hypeBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("signup")
    public String signup(){
        return "registration";
    }

    @PostMapping("result")
    public String createUser(@ModelAttribute UserDto userDto){
        userService.register(userDto);
        return "regicomplete";
    }
    
    @GetMapping("login")
    public String callLoginPage(){
        return "login";
    }

    @GetMapping("/content")
    public String contentSample(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = ((UserDetailsCustom) auth.getPrincipal()).getUser();

        model.addAttribute("user", user);
        return "content";
    }
}
