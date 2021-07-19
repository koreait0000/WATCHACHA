package com.spring.wachacha.user;

import com.spring.wachacha.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int join(UserEntity user);

    UserEntity seluser(String username);
}
