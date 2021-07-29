package com.spring.wachacha.user;

import com.spring.wachacha.user.model.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int join(UserEntity user);
    UserEntity selUser(UserEntity param);
    int updateAuth(UserEntity userEntity);
    int editPw(UserEntity userEntity);
}
