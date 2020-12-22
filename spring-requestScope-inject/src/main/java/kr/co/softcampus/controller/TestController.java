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
 * Time: 오전 11:06
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    DataBean1 requestBean1;

    @Resource(name = "requestBean2")
    DataBean2 requestBean2;

    @Autowired
    DataBean3 requestBean3;

    @Resource(name="requestBean4")
    DataBean4 requestBean4;


    @GetMapping("/test1")
    public String test1(){
        requestBean1.setData1("문자열1");
        requestBean1.setData2("문자열2");

        requestBean2.setData3("문자열3");
        requestBean2.setData4("문자열4");

        requestBean3.setData5("문자열5");
        requestBean3.setData6("문자열6");

        requestBean4.setData7("문자열7");
        requestBean4.setData8("문자열8");

        //-- forward 는 브라우저의 요청이 아니라 서버간의 이동이어서 새로운 객체가 생성되지 않는다.
        return "forward:result1";
    }

    @GetMapping("/result1")
    public String result1(Model model){
        //-- 여기서는 forward 로 이동되었기 때문에 test1 에서 만들어진 Bean 을 그대로 사용하게 되며
        //-- forward 요청이기때문에 request 객체에 DataBean1 저장되지 않는다.
        log.info("requestBean1.data1 : {}", requestBean1.getData1());
        log.info("requestBean1.data2 : {}", requestBean1.getData2());

        log.info("requestBean2.data3 : {}", requestBean2.getData3());
        log.info("requestBean2.data4 : {}", requestBean2.getData4());

        log.info("requestBean3.data5 : {}", requestBean3.getData5());
        log.info("requestBean3.data6 : {}", requestBean3.getData6());

        log.info("requestBean4.data7 : {}", requestBean4.getData7());
        log.info("requestBean4.data8 : {}", requestBean4.getData8());

        model.addAttribute("requestBean1", requestBean1);
        model.addAttribute("requestBean2", requestBean2);
        model.addAttribute("requestBean3", requestBean3);
        model.addAttribute("requestBean4", requestBean4);

        return "result1";
    }


}
