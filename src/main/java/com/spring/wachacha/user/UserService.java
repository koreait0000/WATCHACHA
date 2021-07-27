package com.spring.wachacha.user;

import com.spring.wachacha.config.security.UserDetailsServiceImpl;
import com.spring.wachacha.email.CommonUtils;
import com.spring.wachacha.email.EmailService;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Bean
    public BCryptPasswordEncoder encodePwd(){ return new BCryptPasswordEncoder();}

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private EmailService emailService;
    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserMapper userMapper;

    //UserDetailsServiceImpl userDetails = new UserDetailsServiceImpl();


    public int join(UserEntity user) {
        //비밀번호 암호화
        String authCd = commonUtils.getRandomDigit(6);

        String rawPassword = user.getPw();
        String encPassword = passwordEncoder.encode(rawPassword);
        user.setGrade("UNCASHED");
        user.setPw(encPassword);
        int result = userDetails.join(user);

        String subject = "[WATCHACHA] 이메일 인증번호가 도착하였습니다.";
        String txt = String.format("<div>이메일 계정을 인증받으시려면 아래 링크를 클릭해주세요. (혹시 잘못 전달되었다면 이 이메일을 무시하셔도 됩니다)</div>" +
                        "<a href=\"http://localhost:8090/auth?email=%s&authCd=%s\">링크를 클릭하여 이메일 인증</a>"
                , user.getEmail(), authCd);
        emailService.sendMimeMessage(user.getEmail(), subject, txt);
//test
        return result;

    }

    public void auth(UserEntity userEntity){
        userMapper.updateAuth(userEntity);
    }
}
