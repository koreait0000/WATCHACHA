package com.spring.wachacha.user;

import com.spring.wachacha.config.security.AuthenticationFacadeImpl;
import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.user.model.UserFollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;
    @Autowired private IAuthenticationFacade auth;

    @GetMapping("/mypage")
    public void mypage(){}


    @GetMapping("/profileModify")
    public void modifyPage(){}


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


}
