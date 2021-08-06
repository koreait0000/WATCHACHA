package com.spring.wachacha.main.model;

import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class MovieSearchModel {
    private List<JSONObject> list;
    private String poster;//영화포스터
    private String genre;//영화장르
    private String nation;//국가
    private String link; //영화링크
    private String name; //영화제목
    private String engName;
    private String star; //평점
    private String previewUrl;//예고영상 url
    private Map<String, Object> spec; //개요, 감독, 출연, 등급 등
    private Map<String, Object> summary; //줄거리
    private String bg_url;//배경화면url
    private List<Map<String, Object>> relevant; //연관 영화 추천
}