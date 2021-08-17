package com.spring.wachacha.user.model;

import lombok.Data;

@Data
public class UserFollowEntity {
    private int from_iuser; //iuserMe
    private int to_iuser; //iuserYou
}
