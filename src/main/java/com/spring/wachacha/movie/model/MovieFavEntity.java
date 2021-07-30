package com.spring.wachacha.movie.model;

import lombok.Data;

@Data
public class MovieFavEntity {
    private int iuser;
    private String title; //검색 결과 영화의 제목
    private String image; //검색 결과 영화의 썸네일 이미지의 URL. 이미지가 있는 경우만 나타남.
}
