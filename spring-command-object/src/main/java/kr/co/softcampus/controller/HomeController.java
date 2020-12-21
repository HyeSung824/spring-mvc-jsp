package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @PostMapping("test1")
    public String test1(@ModelAttribute DataBean dataBean){

        log.info("data1 : {}", dataBean.getData1());
        log.info("data2 : {}", dataBean.getData2());

        return "test1";
    }

    //-- 커맨드 객체는 자동으로 HttpServletRequest 객체에 담긴다.
    @PostMapping("test2")
    public String test2(@ModelAttribute("testData") DataBean dataBean){

        log.info("data1 : {}", dataBean.getData1());
        log.info("data2 : {}", dataBean.getData2());

        return "test2";
    }

}
