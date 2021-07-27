package com.spring.wachacha.main.model;

import lombok.Data;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class TestModel {
    private List<JSONObject> list;
    private String poster;
    private String link;
    private String name;
    private List<Map<String, Object>> relevant;
}