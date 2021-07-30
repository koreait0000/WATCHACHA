package com.spring.wachacha.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfileEntity {
    private int iprofile;
    private int iuser;
    private String img;
    private String regdt;
}
