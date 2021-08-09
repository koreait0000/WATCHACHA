package com.spring.wachacha.config.security;

import com.spring.wachacha.config.oauth.PricipalOauth2UserService;
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
@EnableWebSecurity //스프링시큐리티필터가 스프링필터체인게 등록이된다.

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PricipalOauth2UserService oauth2UserService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        // 시큐리티 거치지 않을 곳
        web.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error")
                 .antMatchers("/img/**", "/css/**", "/js/**", "/valid-recaptcha","/selUser","/editPw");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.authorizeRequests()
                .antMatchers("/main/**").authenticated()//로그인한 사람들만
                .antMatchers("/user/**").authenticated()//로그인한 사람들만 pay
                .antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")//매니저권한가진사람만
                .antMatchers("/user").access("hasRole('ROLE_MANAGER')") //결제한사람만
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .usernameParameter("email")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/main/mainpage")
                .failureUrl("/loginForm?param=error")
                .and()
                .oauth2Login()
                .loginPage("/loginForm")
                .defaultSuccessUrl("/main/mainpage")
                .userInfoEndpoint()
                .userService(oauth2UserService);

    }

    /*
        주찬이형방법
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
        */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetails).passwordEncoder(encodePwd());
//    }

}
