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
public class TestController {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String exception1(){
        return "error1";
    }

    @GetMapping("/test1")
    public String test1(Model model){
        // int [] array1 = {10, 20, 30};
        // model.addAttribute("array1", array1[0]);
        // model.addAttribute("array1", array1[10]);

        ArrayList<String> list = null;
        list.add("문자열");

        return "test1";
    }
}
