package com.spring.wachacha.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int iuser;
    private String email;
    private String provider;
    private String pw;
    private String nm;
    private String tel;
    private String grade;
    private String mainProfile;
    private String regdt;

}
