package com.spring.wachacha.user;

import com.spring.wachacha.board.model.PagingDTO;
import com.spring.wachacha.movie.model.MovieFavDomain;
import com.spring.wachacha.movie.model.MovieFavEntity;
import com.spring.wachacha.user.model.UserFollowEntity;
import com.spring.wachacha.user.model.UserDomain;
import com.spring.wachacha.user.model.UserEntity;
import com.spring.wachacha.user.model.UserProfileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int join(UserEntity user);
    UserEntity selUser(UserEntity param);
    int updateAuth(UserEntity userEntity);
    int editPw(UserEntity userEntity);
  
    /* follow */
    int insFollow(UserFollowEntity param);
    UserFollowEntity isFollow(UserFollowEntity param);
    List<UserDomain> selFollower(UserEntity param);
    List<UserDomain> selFollowing(UserEntity param);
    int delFollow(UserFollowEntity param);

    /* movie fav */
    int insMyMovie(MovieFavEntity param);
    List<MovieFavDomain> selMyMovie(UserEntity user, PagingDTO page);
    List<UserEntity> selUserMovieFavOrder(UserEntity param);
    int delMyMovie(MovieFavEntity param);
  
  
    int updUser(UserEntity param);
    int updUserMainProfile(UserEntity param);

    int resetProfile(UserEntity param);

    List<Integer> selFollow(UserEntity entity);
    // follow & movie fav
    List<MovieFavEntity> followerGetMovieFav(Object list);

    List<UserDomain> selUserFollowerList(UserFollowEntity param);
    List<UserDomain> selUserFollowList(UserFollowEntity param);

}
