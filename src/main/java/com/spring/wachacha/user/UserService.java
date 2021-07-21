package com.spring.wachacha.user;

import com.spring.wachacha.config.security.UserDetailsServiceImpl;
import com.spring.wachacha.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    //UserDetailsServiceImpl userDetails = new UserDetailsServiceImpl();


    public int join(UserEntity user) {
        //비밀번호 암호화
        String rawPassword = user.getPw();
        String encPassword = passwordEncoder.encode(rawPassword);
        user.setGrade("UNCASHED");
        user.setPw(encPassword);
        int result = userDetails.join(user);
        return result;

    }
}
