package com.spring.wachacha.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }
}
