package com.ewms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/")
    public String hi(){
        return "Hello World";
    }

}
