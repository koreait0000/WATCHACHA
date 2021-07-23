package com.spring.wachacha.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/mainpage")
    public void mainpage(Model model){
        model.addAttribute("rankPoster",mainService.mainpage());
    }

    @GetMapping("/show")
    public void show(){

    }


}
