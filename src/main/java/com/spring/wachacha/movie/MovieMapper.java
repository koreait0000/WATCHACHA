package com.spring.wachacha.movie;

import com.spring.wachacha.movie.model.MovieFavEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface MovieMapper {
    MovieFavEntity checkMovieFav(MovieFavEntity movieFavEntity);

}
