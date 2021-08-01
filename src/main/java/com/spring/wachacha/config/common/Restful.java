package com.spring.wachacha.config.common;

import com.spring.wachacha.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Restful {
    @Autowired
    private MovieService movieService;

    @PutMapping("/youtube")
    public Map<String, Object> pageChange(String keyword,String page){
        Map<String, Object> map = new HashMap<>();
        map.put("change",movieService.Youtube(keyword, page));
        return map;
    }
}
