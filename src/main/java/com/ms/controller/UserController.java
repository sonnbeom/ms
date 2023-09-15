package com.ms.controller;

import com.ms.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller("/users")
public class UserController {

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDto dto, Errors errors) {
        if (errors.hasErrors()) {
            log.info("userDto invalid: >>" + errors.getFieldError());
            return "home";
        }


        return "home";
    }

}
