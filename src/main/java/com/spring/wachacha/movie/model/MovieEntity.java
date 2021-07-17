package com.spring.wachacha.movie.model;

import lombok.Data;


@Data
public class MovieEntity {
    private int display; //검색 결과 출력 건수를 지정.
    private item[] items;

    @Data
    public static class item {
        public String title; //검색 결과 영화의 제목
        public String link; //검색 결과 영화의 하이퍼텍스트 link
        public String image; //검색 결과 영화의 썸네일 이미지의 URL. 이미지가 있는 경우만 나타남.
        public String subtitle;// 검색 결과 영화의 영문 제목
        public String director; //검색 결과 영화의 감독.
        public String actor; //검색 결과 영화의 출연 배우.
        public float userRating; //검색 결과 영화에 대한 유저들의 평점.

    }
}
