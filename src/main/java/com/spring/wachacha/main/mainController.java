package com.spring.wachacha.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainController {

    @GetMapping("/show")
    public void show(){
        //test
    }

}
