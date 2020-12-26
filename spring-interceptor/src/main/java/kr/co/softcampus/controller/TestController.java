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
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        log.info("TestController - test1");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        log.info("TestController - test2");
        return "test2";
    }

    @GetMapping("/sub1/test3")
    public String test3(){
        log.info("TestController - sub1/test3");
        return "test3";
    }

    @GetMapping("/sub1/test4")
    public String test4(){
        log.info("TestController - sub1/test4");
        return "test4";
    }

}
