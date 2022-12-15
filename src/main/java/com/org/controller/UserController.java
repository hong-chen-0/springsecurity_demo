package com.org.controller;


import com.org.entity.User;
import com.org.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘文鑫
 * @since 2020-11-27
 */
@RestController
public class UserController {
    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}

