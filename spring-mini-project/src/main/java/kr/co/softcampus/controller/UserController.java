package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 9:53
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
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
