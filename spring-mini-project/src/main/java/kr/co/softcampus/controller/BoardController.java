package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 9:36
 */
@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @GetMapping("/main")
    public String main(){
        return "board/main";
    }

    @GetMapping("/read")
    public String read(){
        return "board/read";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    @GetMapping("/modify")
    public String modify(){
        return "board/modify";
    }

    @GetMapping("/delete")
    public String delete(){
        return "board/delete";
    }

}
