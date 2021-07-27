package com.spring.wachacha.config.common;

import com.spring.wachacha.config.recaptcha.VerifyRecaptcha;
import com.spring.wachacha.config.security.UserDetailsImpl;
import com.spring.wachacha.user.UserService;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @Autowired private UserService service;

    @GetMapping("/main")
    public void main(){ }

    @GetMapping({"","/"})
    public String homepage(){
        return "/homepage";
    }

    //로그인페이지
    @GetMapping("/loginForm")
    public void loginForm(Model model){
        model.addAttribute("loginForm","loginForm");

    }

    //회원가입페이지
    @GetMapping("/joinForm")
    public void joinForm(){
    }


    @ResponseBody
    @PostMapping("/valid-recaptcha")
    public int VerifyRecaptcha(HttpServletRequest request) {
        VerifyRecaptcha.setSecretKey("6Lf-IYQbAAAAADJZj_62RLCH0DULZ3hl3NV9f_EH");
        String gRecaptchaResponse = request.getParameter("recaptcha");
        try {
            if(VerifyRecaptcha.verify(gRecaptchaResponse))
                return 0; // 성공
            else return 1; // 실패
        } catch (Exception e) {
            e.printStackTrace();
            return -1; //에러
        }
    }


    @PostMapping("/join")
    public String join(UserEntity user){
        user.setProvider("local");
        service.join(user);
        return "redirect:/loginForm";
    }

    @GetMapping("/test/login")
    @ResponseBody
    public String testLogin(Authentication authentication
            , @AuthenticationPrincipal UserDetailsImpl userDetails){ //DI의존성 주입
        System.out.println("/test/login==============================");
        UserDetailsImpl pricipalDetails = (UserDetailsImpl)authentication.getPrincipal();

        System.out.println("authentication : "+ pricipalDetails.getAttributes());
        return "세션정보확인하기";
    }

    @GetMapping("/test/oauth/login")
    @ResponseBody
    public String testLogin(Authentication authentication
            ,@AuthenticationPrincipal OAuth2User oAuth){ //DI의존성 주입
        System.out.println("/test/oauth/login==============================");

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication : " +oAuth2User.getAttributes());
        System.out.println("oauth2User :" + oAuth.getAttributes());
        return "oauth정보확인하기";
    }





}
