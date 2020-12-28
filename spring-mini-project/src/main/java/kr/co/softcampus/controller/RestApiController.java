package kr.co.softcampus.controller;

import kr.co.softcampus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 2:04
 */
@RestController
@Slf4j
public class RestApiController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/checkUserIdExist/{user_id}")
    public String checkUserIdExist(@PathVariable String user_id){
        boolean chk = userService.checkUserIdExist(user_id);
        return String.valueOf(chk);
    }

}
