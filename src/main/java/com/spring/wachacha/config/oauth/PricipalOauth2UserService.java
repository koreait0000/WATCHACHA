package com.spring.wachacha.config.oauth;

import com.spring.wachacha.config.oauth.provider.*;
import com.spring.wachacha.config.security.UserDetailsServiceImpl;
import com.spring.wachacha.user.UserMapper;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PricipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired private UserDetailsServiceImpl service;
    @Autowired private UserMapper mapper;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2UserInfo userInfo = null;

        System.out.println(userRequest.getClientRegistration());
        System.out.println(userRequest.getAccessToken().getTokenValue());
        System.out.println(oAuth2User.getAttributes());

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글로그인 요청");
            userInfo = new GoogleUserInfo(oAuth2User.getAttributes());
            System.out.println("email: " + userInfo.getEmail());

        }else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("페이스북 로그인 요청");
            userInfo = new FacebookUserInfo(oAuth2User.getAttributes());
            System.out.println("email: " + userInfo.getEmail());

        }else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            userInfo = new NaverUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("response"));
            System.out.println("email: " + userInfo.getEmail());
        }else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
        System.out.println("카카오로그인 요청");
        userInfo = new KakaoUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("properties"));
//
//            LinkedHashMap propertiesData = (LinkedHashMap) oAuth2User.getAttributes().get("properties");
//
//            mod.remove("properties");
//
//            LinkedHashMap kakaoAccountData = (LinkedHashMap) mod.get("kakao_account");
//            mod.putAll(kakaoAccountData);
//            mod.remove("kakao_account");




        System.out.println("email: " + userInfo.getEmail());
        System.out.println("name: " + userInfo.getName());
    }
        else {
            System.out.println("");
        }

        UserEntity param = new UserEntity();
        param.setEmail(userInfo.getEmail());
        param.setProvider(userInfo.getProvider());
        System.out.println("param.getEmail() : " +param.getEmail());
        System.out.println("param.getEmail() : " +param.getProvider());

        UserEntity result = mapper.selUser(param);

        if(result == null ){

            // 1.provider 2.email 3.nm 4. tell null

            param.setNm(userInfo.getName());
            param.setGrade("UNCASHED");
            param.setPw(bCryptPasswordEncoder.encode("login"));
            mapper.join(param);
            System.out.println("login success!");

        }

//        String provider = userInfo.getProvider();
//        String providerId = userInfo.getProviderId();
//        String username = provider + "_" + providerId;
//        String password = bCryptPasswordEncoder.encode("소셜로그인패스워드");
//        String email = userInfo.getEmail();
//        String grade = "ROLE_USER";


        return super.loadUser(userRequest);
    }
}
