package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class SecondController {

//    @ExceptionHandler(NullPointerException.class)
//    public String exception2(){
//        return "error2";
//    }

    @GetMapping("/test2")
    public String test1(){
        ArrayList<String> list = null;
        list.add("문자열");
        return "test2";
    }
}
