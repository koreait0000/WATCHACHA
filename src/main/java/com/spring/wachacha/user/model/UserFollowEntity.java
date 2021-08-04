package com.spring.wachacha.user.model;

import lombok.Data;

@Data
public class UserFollowEntity {
    private int from_iuser;
    private int to_iuser;
}
