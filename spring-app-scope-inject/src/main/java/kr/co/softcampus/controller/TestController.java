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
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class TestController {

    /*
    * @ApplicationScope 은 서버 가동 시 Bean을 주입은 하지만 ApplicationScope 에 객체를 담는 건 아니다.
    * */

    @Autowired
    DataBean1 applicationBean1;

    @Resource(name = "applicationBean2")
    DataBean2 applicationBean2;

    @Autowired
    DataBean3 applicationBean3;

    @Resource(name = "applicationBean4")
    DataBean4 applicationBean4;

    @GetMapping("/test1")
    public String test1(){

        applicationBean1.setData1("data1");
        applicationBean1.setData2("data2");
        applicationBean2.setData3("data3");
        applicationBean2.setData4("data4");

        applicationBean3.setData5("data5");
        applicationBean3.setData6("data6");
        applicationBean4.setData7("data7");
        applicationBean4.setData8("data8");

        return "test1";
    }

    @GetMapping("/result1")
    public String result1(Model model){

        log.info("applicationBean1.data1 : {}", applicationBean1.getData1());
        log.info("applicationBean1.data2 : {}", applicationBean1.getData2());
        log.info("applicationBean2.data3 : {}", applicationBean2.getData3());
        log.info("applicationBean2.data4 : {}", applicationBean2.getData4());

        log.info("applicationBean3.data5 : {}", applicationBean3.getData5());
        log.info("applicationBean3.data6 : {}", applicationBean3.getData6());
        log.info("applicationBean4.data7 : {}", applicationBean4.getData7());
        log.info("applicationBean4.data8 : {}", applicationBean4.getData8());

        model.addAttribute("applicationBean1", applicationBean1);
        model.addAttribute("applicationBean2", applicationBean2);
        model.addAttribute("applicationBean3", applicationBean3);
        model.addAttribute("applicationBean4", applicationBean4);

        return "result1";
    }
}
