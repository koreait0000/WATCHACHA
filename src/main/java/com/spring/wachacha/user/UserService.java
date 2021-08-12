package com.spring.wachacha.user;

import com.spring.wachacha.board.model.PagingDTO;
import com.spring.wachacha.config.files.MyFileUtils;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.config.security.UserDetailsServiceImpl;
import com.spring.wachacha.email.CommonUtils;
import com.spring.wachacha.email.EmailService;
import com.spring.wachacha.movie.model.MovieFavDomain;
import com.spring.wachacha.user.model.UserDomain;
import com.spring.wachacha.user.model.UserEntity;
import com.spring.wachacha.user.model.UserFollowEntity;
import com.spring.wachacha.user.model.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Bean
    public BCryptPasswordEncoder encodePwd(){ return new BCryptPasswordEncoder();}

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private EmailService emailService;
    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserProfileMapper profileMapper;
    @Autowired
    private MyFileUtils myFileUtils;
    @Autowired
    private IAuthenticationFacade auth;


    //UserDetailsServiceImpl userDetails = new UserDetailsServiceImpl();

    public String lossPw(UserEntity user){
        String authCd = commonUtils.getRandomDigit(6);
        System.out.println(authCd);
        String subject = "[WATCHACHA] 이메일 인증번호가 도착하였습니다.";
        String txt = String.format("<div>인증 번호는 %s입니다.</div>", authCd);
        emailService.sendMimeMessage(user.getEmail(), subject, txt);
        return authCd;
    }

    public int selUser(UserEntity user){
        user.setProvider("local");
        UserEntity userEntity = userMapper.selUser(user);
        if(userEntity == null){
            return 0;
        }else{
            if(user.getPw() != null){
                if(passwordEncoder.matches(user.getPw(),userEntity.getPw())){
                    return 2;
                }else{
                    return 0;
                }
            }else{
                return 1;
            }
        }
    }

    public int editPw(UserEntity user){
        String hashPw = passwordEncoder.encode(user.getPw());
        user.setPw(hashPw);
        return userMapper.editPw(user);
    }

    public int join(UserEntity user) {
        //비밀번호 암호화
        String authCd = commonUtils.getRandomDigit(6);

        String rawPassword = user.getPw();
        String encPassword = passwordEncoder.encode(rawPassword);
        user.setGrade("UNCASHED");
        user.setPw(encPassword);
        user.setAuthCd(authCd);
        int result = userDetails.join(user);

        String subject = "[WATCHACHA] 이메일 인증번호가 도착하였습니다.";
        String txt = String.format("<div>이메일 계정을 인증받으시려면 아래 링크를 클릭해주세요. (혹시 잘못 전달되었다면 이 이메일을 무시하셔도 됩니다)</div>" +
                        "<a href=\"http://localhost:8090/auth?email=%s&authCd=%s\">링크를 클릭하여 이메일 인증</a>"
                , user.getEmail(), authCd);
        emailService.sendMimeMessage(user.getEmail(), subject, txt);
//test
        return result;

    }

    public void auth(UserEntity userEntity){
        userMapper.updateAuth(userEntity);
    }

    public List<UserProfileEntity> selUserProfileList(UserEntity param) {
        return profileMapper.selUserProfileList(param);
    }

    //메인 이미지 변경
    public Map<String, Object> updUserMainProfile(UserProfileEntity param) {
        UserEntity loginUser = auth.getLoginUser();

        param.setIuser(loginUser.getIuser());
        int result = userMapper.updUserMainProfile(param);
        if(result == 1) { //시큐리티 세션에 있는 loginUser에 있는 mainProfile값도 변경해주어야 한다.
            System.out.println("img : " + param.getImg());
            loginUser.setMainProfile(param.getImg());
        }
        Map<String, Object> res = new HashMap();
        res.put("result", result);
        res.put("img", param.getImg());
        return res;
    }



    // 팔로우
    public UserFollowEntity insFollow(UserFollowEntity param) {
        int test = userMapper.insFollow(param);
        if(test == 0) return null;
        return userMapper.isFollow(param);
    }
    public UserFollowEntity delFollow(UserFollowEntity param) {
        int test = userMapper.delFollow(param);
        if(test == 0) return null;
        return userMapper.isFollow(param);
    }
    public List<UserDomain> selFollower(UserEntity param) {
        if(param.getIuser() == 0) {
            param.setIuser(auth.getLoginUserPk());
        }
        return userMapper.selFollower(param);
    }
    public List<UserDomain> selFollowing(UserEntity param) {
        if(param.getIuser() == 0) {
            param.setIuser(auth.getLoginUserPk());
        }
        return userMapper.selFollowing(param);
    }

    // 팔로우 한 사람들이 좋아요 한 영화
    public Map<String, List<MovieFavDomain>> selFollowingFav(UserEntity param) {
        if(param.getIuser() == 0) {
            param.setIuser(auth.getLoginUserPk());
        }
        Map<String, List<MovieFavDomain>> result = new HashMap();
        List<UserEntity> userList = userMapper.selUserMovieFavOrder(param);
        for(UserEntity user : userList) {
            List<MovieFavDomain> list = userMapper.selMyMovie(user, new PagingDTO(1));
            result.put(list.get(0).getNm(), list);
        }
        return result;
    } // key 는 사람 이름, value 는 좋아요한 영화 리스트.

    // 내가 좋아요 한 영화
    public List<MovieFavDomain> getMyMovie(PagingDTO pagingDTO) {
        return userMapper.selMyMovie(auth.getLoginUser(), pagingDTO);
    }

    /*프로필이미지 변경*/
    public void modProfile(MultipartFile[] imgArr) {
        UserEntity loginuser = auth.getLoginUser();
        System.out.println("loginUser :" +loginuser);
        System.out.println("loginuser.getIuser(); : " + loginuser.getIuser());

        int iuser = loginuser.getIuser();
        System.out.println("iuser : " + iuser);

        String target = "profile/"+iuser;

        UserProfileEntity param = new UserProfileEntity();
        param.setIuser(iuser);

        for (MultipartFile img : imgArr){
            //파일을 서버에 넣는거
            String saveFileNm = myFileUtils.transferTo(img, target);
            if (saveFileNm != null){
                param.setImg(saveFileNm);
                //메인프로필을 처음으로 넣을때
                if (profileMapper.insUserProfile(param) == 1 || loginuser.getMainProfile() == null){

                    UserEntity param2 = new UserEntity();
                    param2.setIuser(iuser);
                    param2.setMainProfile(saveFileNm);

                    System.out.println("profileMapper.insUserProfile(param) 실행됨");

                    if(userMapper.updUser(param2) == 1){
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("userMapper.updUser(param2) == 1 실행됨");
                        loginuser.setMainProfile(saveFileNm);
                    }
                }
            }
        }
    }
    //이미지값을 null로 바꿈
    public int resetProfileImg() {
        UserEntity param = auth.getLoginUser();
        return userMapper.resetProfile(param);
    }
}
