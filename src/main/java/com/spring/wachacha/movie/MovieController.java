package com.spring.wachacha.movie;

import com.spring.wachacha.config.security.UserDetailsImpl;
import com.spring.wachacha.movie.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public String MovieSearch() {
        return "movie/search";
    }

    @GetMapping("/api/vi/movies/{keyword}")
    public MovieEntity get(@PathVariable String keyword) {
        return movieService.findByKeyword(keyword);
    }

    @GetMapping("/movie/detail")
    public String movieYoutube(String keyword, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("movie",movieService.info(keyword));
        model.addAttribute("username",userDetails.getUser().getNm());
        //model.addAttribute("youtube",movieService.Youtube(keyword,page));
        return "movie/detail";
    }





}
