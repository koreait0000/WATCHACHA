package com.spring.wachacha.main;

import com.spring.wachacha.main.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;
//testasd
    @GetMapping("/mainpage")
    public void mainpage(Model model){
        model.addAttribute("map",mainService.mainpage());
    }

    @GetMapping("/show")
    public void show(){

    }

    @GetMapping("/searchResult")
    public String searchResult(String searchbar,Model model){
        model.addAttribute("test",mainService.searchResult(searchbar));
        return "main/searchResult";
    }


}
