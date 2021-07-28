package com.spring.wachacha.config.security;

import com.spring.wachacha.user.model.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Data
public class UserDetailsImpl implements UserDetails, OAuth2User {


    private UserEntity user;
    private Map<String, Object> attributes;


    //생성자호출
    public UserDetailsImpl(UserEntity user) { this.user = user; }

    //오어스로그인할때의 생성자
    public UserDetailsImpl(UserEntity user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() { return user.getPw(); }

    @Override
    public String getUsername() { return user.getNm(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

//    OAuth2User의 오버라이딩
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return user.getNm();
    }

}
