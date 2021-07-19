package com.spring.wachacha.config.common;

import com.spring.wachacha.user.UserService;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {

    @Autowired private UserService service;


    @GetMapping({"","/"})
    public String homepage(){
        return "/homepage";
    }

    //로그인페이지
    @GetMapping("/loginForm")
    public void loginForm(){ }

    //회원가입페이지
    @GetMapping("/joinForm")
    public void joinForm(){ }


    @PostMapping("/join")
    public String join(UserEntity user){

        service.join(user);
        return "redirect:/loginForm";
    }





}
