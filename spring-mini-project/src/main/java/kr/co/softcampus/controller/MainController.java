package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 9:18
 */
@Controller
@Slf4j
public class MainController {

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
