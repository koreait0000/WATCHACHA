package com.spring.wachacha.main;

import com.spring.wachacha.config.security.UserDetailsImpl;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/mainpage")
    public void mainpage(Model model){
        model.addAttribute("map",mainService.mainpage());
    }

    @GetMapping("/show")
    public void show(){

    }

    @GetMapping("/searchResult")
    public String searchResult(String searchbar, Model model){
        model.addAttribute("user",mainService.userSearch(searchbar));
        model.addAttribute("test",mainService.searchResult(searchbar));
        return "main/searchResult";
    }
}
