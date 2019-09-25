package com.iotknowyou.springMVC.MVCDemoOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class HelloWorldController {

    @RequestMapping(value = "hello.do")
    public ModelAndView Hello(HttpServletRequest request){
        ModelAndView m = new ModelAndView("HelloWorld");
        return  m;
    }
}
