package com.spring.wachacha.config.security;

import com.spring.wachacha.user.UserMapper;
import com.spring.wachacha.user.model.UserEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserMapper mapper;

    @Override //loginPost
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UserDetailsImpl(loadUserByUsernameAndProvider(email, "local"));
    }

    public UserEntity loadUserByUsernameAndProvider(String email, String provider) throws UsernameNotFoundException {
        System.out.println("loadUserbyusername 실행됨");
        UserEntity param = new UserEntity();
        param.setProvider(provider);
        param.setEmail(email);
        UserEntity result = mapper.selUser(param);
        if(result == null) {
            result = new UserEntity();
        }
        return result;
    }

    //local join
    public int join(UserEntity user){
        if(user == null){
            return 0;
        }
        return mapper.join(user);
    }


}
