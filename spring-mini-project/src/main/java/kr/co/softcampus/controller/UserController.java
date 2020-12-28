package kr.co.softcampus.controller;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.UserService;
import kr.co.softcampus.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        UserValidator validator1 = new UserValidator();
        binder.addValidators(validator1);
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
                        @RequestParam(value = "fail", defaultValue = "false") boolean fail,
                        Model model) {

        model.addAttribute("fail", fail);

        return "user/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
                            BindingResult result) {

        if (result.hasErrors()) {
            return "user/login";
        }

        userService.getLoginUserInfo(tempLoginUserBean);

        if (loginUserBean.isUserLogin()) {
            return "user/login_success";
        }

        return "user/login_fail";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinUserBean") UserBean userBean) {
        return "user/join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean userBean,
                           BindingResult result) {

        if (result.hasErrors()) {
            return "user/join";
        }

        userService.addUserInfo(userBean);

        return "user/join_success";
    }

    @GetMapping("/modify")
    public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean) {
        userService.getModifyUserInfo(modifyUserBean);
        return "user/modify";
    }

    @PostMapping("/modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean,
                             BindingResult result) {
        if(result.hasErrors()){
            return "user/modify";
        }

        userService.modifyUserInfo(modifyUserBean);

        return "user/modify_success";
    }

    @GetMapping("/logout")
    public String logout() {

        loginUserBean.setUserLogin(false);

        return "user/logout";
    }

    @GetMapping("/not_login")
    public String not_login() {
        return "user/not_login";
    }
}
