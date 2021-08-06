package com.spring.wachacha;

import com.google.gson.Gson;

import java.util.Map;

public class Imsi {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String str = "{id=1822708053, connected_at='2021-07-26T07:02:48Z', properties={nickname=옥찬호}, kakao_account={profile_nickname_needs_agreement=false, profile={nickname=옥찬호}, has_email=true, email_needs_agreement=false, is_email_valid=true, is_email_verified=true, email=j33515@kakao.com}}";
        Map<String,Object> attributes = gson.fromJson(str,Map.class);
        attributes.entrySet().forEach(entry->{
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
        Map<String, Object> map = (Map<String, Object>)((Map<String, Object>) attributes.get("kakao_account")).get("profile");
        String result = (String) map.get("nickname");
        System.out.println(result);

    }
}
