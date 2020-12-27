package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class BasicController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}
