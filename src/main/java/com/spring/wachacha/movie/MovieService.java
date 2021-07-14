package com.spring.wachacha.movie;

import com.spring.wachacha.movie.model.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieApiClient movieApiClient;

    @Transactional(readOnly = true)
    public MovieEntity findByKeyword(String keyword){
        return movieApiClient.requestMovie(keyword);
    }
}
