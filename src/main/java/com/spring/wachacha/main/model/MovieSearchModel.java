package com.spring.wachacha.main.model;

import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class MovieSearchModel {
    private List<JSONObject> list;
    private String poster;
    private String link; 
    private String name; //영화제목
    private String engName;
    private String star; //평점
    private Map<String, Object> spec; //개요, 감독, 출연, 등급 등
    private Map<String, Object> summary; //줄거리
    private String bg_url;
    private List<Map<String, Object>> relevant; //연관 영화 추천
}