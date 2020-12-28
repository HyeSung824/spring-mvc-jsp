package kr.co.softcampus.controller;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.UserService;
import kr.co.softcampus.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 9:53
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        UserValidator validator1 = new UserValidator();
        binder.addValidators(validator1);
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinUserBean") UserBean userBean){
        return "user/join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean userBean,
           BindingResult result){

        if(result.hasErrors()){
            return "user/join";
        }

        userService.addUserInfo(userBean);

        return "user/join_success";
    }

    @GetMapping("/modify")
    public String modify(){
        return "user/modify";
    }

    @GetMapping("/logout")
    public String logout(){
        return "user/logout";
    }
}
