package com.spring.wachacha.user.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDomain extends UserEntity{

    private int cntFollower; //팔로워 카운트
    private int cntFollow; //팔로우 카운트
    private int isYouFollowMe; //너는 나를 팔로우 했니
    private int isMeFollowYou; //나는 너를 팔로우 했니

}
