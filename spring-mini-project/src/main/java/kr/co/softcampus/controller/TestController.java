package kr.co.softcampus.controller;

import kr.co.softcampus.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 8:20
 */
@Controller
@Slf4j
public class TestController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/test1")
    public String test1(Model model){
        String str = testService.testMethod();
        model.addAttribute("str", str);
        return "test1";
    }
}
