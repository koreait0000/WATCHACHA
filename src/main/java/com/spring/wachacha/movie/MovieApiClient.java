package com.spring.wachacha.movie;

import com.spring.wachacha.movie.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieApiClient {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private static final String CLIENT_ID = "hrAczvypQUPoRvukXBXu";
    private static final String CLIENT_SECRET = "VH35ez8juR";

    private static final String OpenNaverMovieUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query=yes";



    public MovieEntity requestMovie(String keyword) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret",CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<MovieEntity> responseEntity = restTemplate.exchange(OpenNaverMovieUrl_getMovies, HttpMethod.GET, entity, MovieEntity.class,keyword);
        MovieEntity movie = responseEntity.getBody();

        System.out.println(movie);

        return movie;


    }
}