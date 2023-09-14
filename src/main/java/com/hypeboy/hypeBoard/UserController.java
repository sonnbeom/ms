package com.hypeboy.hypeBoard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class UserController {

    UserRepository userRepo;
    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/reg")
    public String reg(@RequestBody User user) {
        log.info("controller: >> " + user);
        userRepo.findById(user.getId());
        return "home";
    }
}
