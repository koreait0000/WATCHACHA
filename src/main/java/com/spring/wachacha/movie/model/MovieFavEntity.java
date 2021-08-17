package com.spring.wachacha.movie.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MovieFavEntity {
    private int i_movie_fav;
    private int iuser;
    private String title; //검색 결과 영화의 제목
    private String image; //검색 결과 영화의 썸네일 이미지의 URL. 이미지가 있는 경우만 나타남.
    private String nation;
    private String genre;
    private String nm;
}
