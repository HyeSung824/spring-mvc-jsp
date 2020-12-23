package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/test1")
    public String test1(Model model, Locale locale){

        log.info("locale : {}", locale);

        String a1 = messageSource.getMessage("aaa.a1", null, null);
        String b1 = messageSource.getMessage("bbb.b1", null, null);

        Object[] args = {30, "홍길동"};

        String a2 = messageSource.getMessage("aaa.a2", args, null);

        String a3 = messageSource.getMessage("aaa.a3", null, locale);

        log.info("aaa.a1 : {}", a1);
        log.info("aaa.a2 : {}", a2);
        log.info("aaa.a3 : {}", a3);
        log.info("bbb.b1 : {}", b1);

        model.addAttribute("args", args);

        return "test1";
    }

}
