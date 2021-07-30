package com.spring.wachacha.config.security;

import com.spring.wachacha.user.model.UserEntity;

public interface IAuthenticationFacade {
    UserEntity getLoginUser();
    int getLoginUserPk();
}
