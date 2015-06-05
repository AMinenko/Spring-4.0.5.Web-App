package com.anmi.webapp.controllers;

import com.anmi.webapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String index(){
        accountService.getOne(1L);
        return "index";
    }
}
