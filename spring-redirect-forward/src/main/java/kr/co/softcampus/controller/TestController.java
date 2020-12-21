package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 8:59
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "redirect:/sub1";
    }

    @GetMapping("/sub1")
    public String sub1(){
        return "sub1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "forward:/sub2";
    }

    @GetMapping("/sub2")
    public String sub2(){
        return "sub2";
    }
}
