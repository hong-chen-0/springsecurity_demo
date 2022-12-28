package com.org.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @PreAuthorize("hasAnyRole('TEST','ADMIN')")
    @RequestMapping("test")
    public String test(){
        return "test";
    }
}

