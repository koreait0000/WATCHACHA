package com.spring.wachacha.user;

import com.spring.wachacha.board.model.PagingDTO;
import com.spring.wachacha.config.security.AuthenticationFacadeImpl;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.movie.model.MovieFavDomain;
import com.spring.wachacha.user.model.UserFollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;
    @Autowired private IAuthenticationFacade auth;

    @GetMapping("/mypage")
    public void mypage(){}


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

}
