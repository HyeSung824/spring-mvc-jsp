package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 1:56
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("test1")
    public String test1(DataBean bean){

        bean.setA1("data1");
        bean.setA2("data2");
        bean.setA3("data3");
        bean.setA4("data4");

        return "test1";
    }
}
