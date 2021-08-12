package com.spring.wachacha.user;

import com.spring.wachacha.board.model.PagingDTO;
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

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;
    @Autowired private IAuthenticationFacade auth;




    @GetMapping("/mypage")
    public void mypage(Model model, UserEntity param, @AuthenticationPrincipal UserDetailsImpl userDetails){
        UserDTO param2 = new UserDTO();
        param2.setYouIuser(param.getIuser());
        if (param2.getYouIuser() == 0){
            param2.setYouIuser(userDetails.getUser().getIuser());
            param.setIuser(userDetails.getUser().getIuser());
        }

    }


    @GetMapping("/profileMod")
    public void profileMod(){}

    @ResponseBody
    @GetMapping("/getMyMovie")
    public List<MovieFavDomain> getMyMovie(int page) {
        PagingDTO pagingDTO = new PagingDTO(page);
        System.out.println("paing = " + pagingDTO);
        return service.getMyMovie(pagingDTO);
    }


    @ResponseBody
    @PostMapping("/follow")
    public UserFollowEntity insFollow(@RequestBody UserFollowEntity param) {
        param.setFrom_iuser(auth.getLoginUserPk());
        return service.insFollow(param);
    }
    @ResponseBody
    @DeleteMapping("/follow")
    public UserFollowEntity delFollow(@RequestBody UserFollowEntity param) {
        param.setFrom_iuser(auth.getLoginUserPk());
        return service.delFollow(param);
    }

    /* settingPage 작업*/
    @GetMapping("/setting")
    public void setting(){}


    /*프로필이미지 변경*/
    @PostMapping("/modProfile")
    public String modProfile(MultipartFile[] file){
        service.modProfile(file);
        return "redirect:profileMod";
    }

    @ResponseBody
    @GetMapping("/resetProfileImg")
    public int resetProfileImg(){
        int result = service.resetProfileImg();// null 값을 바꾸는거
        auth.getLoginUser().setMainProfile(null);
        return result;
    }
}
