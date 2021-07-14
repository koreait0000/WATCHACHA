package com.spring.wachacha.movie;

import com.spring.wachacha.movie.model.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movie")
    public String movieSearch(){
        return "movie/search";
    }

    @GetMapping("/api/vi/movies/{keyword}")
    public MovieEntity get(@PathVariable String keyword){
       return movieService.findByKeyword(keyword);
    }
}
