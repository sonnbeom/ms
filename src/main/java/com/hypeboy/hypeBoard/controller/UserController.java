package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
  
    @PostMapping("/myPage")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model){
        model.addAttribute("user",userService.join(id,pwd));
        return "mypage";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
