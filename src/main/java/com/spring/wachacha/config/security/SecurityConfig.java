package com.spring.wachacha.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetails;

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 시큐리티 거치지 않을 곳
        web.ignoring().antMatchers("/favicon.ico", "/resources/**", "error")
                .antMatchers("/img/**", "/css/**", "/js/**");
    }

    @Override
    public void configure(HttpSecurity security) throws Exception{
        security.csrf().disable();

        security.authorizeRequests() // 로그인 없이 갈 수 있는 페이지들
                .antMatchers("/user/login", "/user/join")
                .permitAll().anyRequest().authenticated();

        security.formLogin()
                .loginPage("/user/login") // 로그인 페이지
                .usernameParameter("email") // 아이디 변수
                .passwordParameter("upw") // 페스워드 변수
                .defaultSuccessUrl("/home/hoem"); // 로그인 성공시 갈 곳

        security.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃 요청 페이지
                .logoutSuccessUrl("/user/login") // 로그아웃 하고 갈 페이지
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
}
