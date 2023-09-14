package com.hypeboy.hypeBoard.controller;

import com.hypeboy.hypeBoard.dto.UserDto;
import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Log4j2
@Controller
@SessionAttributes("user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value ="/user/new")
    public String createUser(@ModelAttribute UserDto userDto){

        System.out.println(userDto.toString());;

        log.info("dfsdfs");
        User user =new User(userDto);
        log.info(user);
        userService.Registration(user);
        log.info("check2");
        return "regiComplete";
    }
    @GetMapping("/ms")
    public String start(){
        System.out.println("ms...");
        return "registration";
    }
    @GetMapping("/ms/login")
    public String RegiAfterLogin(){
        return "login";
    }
    @PostMapping(value = "/user/login")
    public String loginUser(@RequestParam("id") String id,@RequestParam("pwd") String pwd ,HttpSession session){
        //@RequestParam() 괄호 안에 들어갈 내용은 input name과 일치해야함
        session.setAttribute("user", userService.userJoin(id,pwd));
        return "loginComplete";
    }

}

