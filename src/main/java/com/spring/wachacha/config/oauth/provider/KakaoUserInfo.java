package com.spring.wachacha.config.oauth.provider;

import lombok.Data;
import org.json.simple.JSONObject;

import java.util.Map;
@Data
public class KakaoUserInfo implements OAuth2UserInfo{

    public Map<String, Object> attributes;

    public KakaoUserInfo(Map<String, Object> attributes) { this.attributes = attributes; }

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }
    @Override
    public String getEmail() { return (String) attributes.get("email"); }

    @Override
    public String getName() {
        Map<String, Object> map = (Map<String, Object>) attributes.get("profile");
        String result = map.get("nickname").toString();
        System.out.println(result);
        return result;
    }

}
