package com.spring.wachacha.user;

import com.spring.wachacha.board.model.PagingDTO;
import com.spring.wachacha.config.common.MyConst;
import com.spring.wachacha.config.security.AuthenticationFacadeImpl;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.config.security.UserDetailsImpl;
import com.spring.wachacha.movie.model.MovieFavDomain;
import com.spring.wachacha.user.model.UserDTO;
import com.spring.wachacha.user.model.UserEntity;
import com.spring.wachacha.user.model.UserFollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;
    @Autowired private IAuthenticationFacade auth;
    @Autowired private MyConst myConst;



    @GetMapping("/mypage")
    public void mypage(Model model, UserEntity param, @AuthenticationPrincipal UserDetailsImpl userDetails){

        UserDTO param2 = new UserDTO();

        param2.setYouIuser(param.getIuser()); //어차피 0아닌가

        if (param2.getYouIuser() == 0){
            param2.setYouIuser(userDetails.getUser().getIuser()); //나의 iuser값
            param.setIuser(userDetails.getUser().getIuser()); //나의 iuser값
        }
          model.addAttribute(myConst.PROFILE, service.selUserProfile(param2)); // 프로필 정보
          model.addAttribute(myConst.PROFILE_LIST, service.selUserProfileList(param)); // ??


    }


    @GetMapping("/profileMod")
    public void profileMod(){}

    @ResponseBody
    @GetMapping("/getMyMovie")
    public List<MovieFavDomain> getMyMovie(UserEntity param, int page) {
        PagingDTO pagingDTO = new PagingDTO(page);
        System.out.println("paing = " + pagingDTO);
        return service.getMyMovie(param, pagingDTO);
    }

    @ResponseBody
    @GetMapping("/follow")
    public UserFollowEntity checkFollow(UserFollowEntity param) {
        return service.checkFollow(param);
    }

    @ResponseBody
    @PostMapping("/follow")
    public int insFollow(@RequestBody UserFollowEntity param) {
        param.setFrom_iuser(auth.getLoginUserPk());
        return service.insFollow(param);
    }

    @ResponseBody
    @DeleteMapping("/follow/{to_iuser}")
    public int delFollow(@PathVariable(name="to_iuser") int to_iuser) {
        UserFollowEntity param = new UserFollowEntity();
        param.setTo_iuser(to_iuser);
        param.setFrom_iuser(auth.getLoginUserPk());
        return service.delFollow(param);
    }

    /* settingPage 작업*/
    @GetMapping("/setting")
    public void setting(){}


    /*프로필이미지 변경*/
//    @PostMapping("/modProfile")
//    public String modProfile(MultipartFile[] file){
//        service.modProfile(file);
//        return "redirect:profileMod";
//    }

    @ResponseBody
    @GetMapping("/resetProfileImg")
    public int resetProfileImg(){
        int result = service.resetProfileImg();// null 값을 바꾸는거
        auth.getLoginUser().setMainProfile(null);
        return result;
    }

    @ResponseBody
    @PostMapping("/uploadProfile")
    public Map<String, Integer> uploadProfile(MultipartFile imgArr,UserEntity  param){
        System.out.println("imgArr : " +imgArr);
        System.out.println("param :" + param);
        Map<String, Integer> res = new HashMap();
        res.put("result", service.uploadProfile(imgArr, param));
        return res;
    }

}
