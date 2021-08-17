package com.spring.wachacha.user;

import com.spring.wachacha.user.model.UserDTO;
import com.spring.wachacha.user.model.UserDomain;
import com.spring.wachacha.user.model.UserEntity;
import com.spring.wachacha.user.model.UserProfileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserProfileMapper {
    int insUserProfile(UserProfileEntity param);
    int updUserProfile(UserProfileEntity param);
    List<UserProfileEntity> selUserProfileList(UserEntity param);
    UserDomain selUserProfile(UserDTO param2);

}
