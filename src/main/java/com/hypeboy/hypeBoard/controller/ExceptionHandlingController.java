package com.hypeboy.hypeBoard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlingController {
//    private final ModelAndView modelAndView;
//
//    @Autowired
//    public ExceptionHandlingController(ModelAndView modelAndView) {
//        this.modelAndView = modelAndView;
//    }

    //Spring은 해당 클래스를 검사하고 @ExceptionHandler 어노테이션을 발견
    @ExceptionHandler(IllegalStateException.class)
    //어노테이션의 인자와 메소드의 인자는 동일해야한다.
    public ModelAndView exceptionHandle(IllegalStateException ex){
        //생성자의 매개변수로 전달된 "error"는 뷰의 이름(html 이름)
        ModelAndView modelAndView = new ModelAndView("error");
        //html에 ${errorMessage}에 ex.getMessage가 출력된다.
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView nosuchElementExcep(NoSuchElementException empty){
        ModelAndView modelAndView =new ModelAndView("error");
        modelAndView.addObject("errorMessage",empty.getMessage());
        return modelAndView;
    }
}
