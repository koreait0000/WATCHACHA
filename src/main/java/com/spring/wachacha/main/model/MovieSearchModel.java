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
    private String name;
    private Map<String, Object> summary; //줄거리
    private List<Map<String, Object>> relevant;
}