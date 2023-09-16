package com.hypeboy.hypeBoard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@ControllerAdvice

public class ExceptionHandlingController {
    @ExceptionHandler(IllegalStateException.class)
    public ModelAndView illegalExHandler(IllegalStateException illegalExHanle) {
        return errorMsg(illegalExHanle.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView noSuchExHandler(NoSuchElementException noSuchExHandle) {
       return errorMsg(noSuchExHandle.getMessage());
    }
    private ModelAndView errorMsg(String errorMessage){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

}

