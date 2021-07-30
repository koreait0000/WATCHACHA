package com.spring.wachacha.user;

import com.spring.wachacha.config.files.MyFileUtils;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.config.security.UserDetailsServiceImpl;
import com.spring.wachacha.email.CommonUtils;
import com.spring.wachacha.email.EmailService;
import com.spring.wachacha.user.model.UserEntity;
import com.spring.wachacha.user.model.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        if(userMapper.selUser(user) == null){
            return 0;
        }else{
            return 1;
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

    public void profileImg(MultipartFile[] imgArr) {
        UserEntity loginUser = auth.getLoginUser();
        int iuser = loginUser.getIuser();

        System.out.println("user_no : " + iuser);
        String target = "profile/" + iuser;

        UserProfileEntity param = new UserProfileEntity();
        param.setIuser(iuser); //11

        for(MultipartFile img : imgArr) {
            String saveFileNm = myFileUtils.transferTo(img, target); //"weioj435lknsio.jpg"
            if(saveFileNm != null) {
                param.setImg(saveFileNm);
                if(profileMapper.insUserProfile(param) == 1 && loginUser.getMainProfile() == null) {
                    UserEntity param2 = new UserEntity();
                    param2.setIuser(iuser); //11
                    param2.setMainProfile(saveFileNm);

                    if(userMapper.updUser(param2) == 1) {
                        loginUser.setMainProfile(saveFileNm);
                    }
                }
            }
        }
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
}
