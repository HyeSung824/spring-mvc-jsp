package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * Created by 김홍준
 * Date: 2020-12-22
 * Time: 오후 4:39
 */
@Controller
@Slf4j
public class TestController {
    /*
    * Session Scope
    * Bean 을 정의할 때 session scope 로 정의하면 브라우저가 서버에 최초의 요청을 보낼 때
    * Bean 객체가 주입됩니다.
    * 주입된 Bean 은 주입만 이루어지는 것이므로 session 영역에 저장되지는 않습니다.
    * */

    @Autowired
    DataBean1 sessionBean1;

    @Resource(name = "sessionBean2")
    DataBean2 sessionBean2;

    @Autowired
    DataBean3 sessionBean3;

    @Resource(name = "sessionBean4")
    DataBean4 sessionBean4;

    @GetMapping("/test1")
    public String test1(){

        sessionBean1.setData1("data1");
        sessionBean1.setData2("data2");
        sessionBean2.setData3("data3");
        sessionBean2.setData4("data4");

        sessionBean3.setData5("data5");
        sessionBean3.setData6("data6");
        sessionBean4.setData7("data7");
        sessionBean4.setData8("data8");

        return "test1";
    }

    @GetMapping("/result1")
    public String result1(Model model){
        log.info("sessionBean1.data1 : {}", sessionBean1.getData1());
        log.info("sessionBean1.data2 : {}", sessionBean1.getData2());
        log.info("sessionBean2.data3 : {}", sessionBean2.getData3());
        log.info("sessionBean2.data4 : {}", sessionBean2.getData4());

        log.info("sessionBean3.data5 : {}", sessionBean3.getData5());
        log.info("sessionBean3.data6 : {}", sessionBean3.getData6());
        log.info("sessionBean4.data7 : {}", sessionBean4.getData7());
        log.info("sessionBean4.data8 : {}", sessionBean4.getData8());

        model.addAttribute("sessionBean1", sessionBean1);
        model.addAttribute("sessionBean2", sessionBean2);

        model.addAttribute("sessionBean3", sessionBean3);
        model.addAttribute("sessionBean4", sessionBean4);

        return "result1";
    }
}
