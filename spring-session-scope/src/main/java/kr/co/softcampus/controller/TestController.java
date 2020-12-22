package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by 김홍준
 * Date: 2020-12-22
 * Time: 오후 4:39
 */
@Controller
@Slf4j
@SessionAttributes(value = {"sessionBean1", "sessionBean2"})
public class TestController {

    @ModelAttribute("sessionBean1")
    public DataBean1 sessionBean1(){
        log.info("=========================================");
        log.info("sessionBean1 함수 호출");
        log.info("=========================================");
        return new DataBean1();
    }

    @ModelAttribute("sessionBean2")
    public DataBean1 sessionBean2(){
        log.info("=========================================");
        log.info("sessionBean2 함수 호출");
        log.info("=========================================");
        return new DataBean1();
    }

    @GetMapping("/test1")
    public String test1(HttpSession session){
        session.setAttribute("data1", "문자열1");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(HttpSession session){
        session.setAttribute("data1", "문자열2");
        return "redirect:/result1";
    }

    @GetMapping("/test3")
    public String test3(HttpSession session){
        session.setAttribute("data1", "문자열3");
        return "forward:/result1";
    }

    @GetMapping("/result1")
    public String result1(HttpSession session){
        String data1 = (String)session.getAttribute("data1");
        log.info("data1 : {}", data1);
        return "result1";
    }

    /*@GetMapping("/test4")
    public String test4(HttpSession session){
        DataBean1 bean1 = new DataBean1();
        bean1.setData1("문자열4");
        bean1.setData2("문자열5");
        session.setAttribute("bean1", bean1);
        return "test4";
    }*/

    /*@GetMapping("/result4")
    public String result4(HttpSession session){
        DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
        log.info("bean1.data1 : {}", bean1.getData1());
        log.info("bean1.data2 : {}", bean1.getData2());
        return "result4";
    }*/

    //-- SessionAttribute 에 해당하는 세션이 없으면 NULL 반환
    @GetMapping("/test4")
    public String test4(
            @SessionAttribute("bean1") Optional<DataBean1> optional,
            HttpSession session){

        DataBean1 bean1 = optional.orElse(new DataBean1());
        bean1.setData1("문자열4");
        bean1.setData2("문자열5");

        session.setAttribute("bean1", bean1);

        return "test4";
    }

    @GetMapping("/result4")
    public String result4(@SessionAttribute("bean1") DataBean1 bean1){
        log.info("bean1.data1 : {}", bean1.getData1());
        log.info("bean1.data2 : {}", bean1.getData2());
        return "result4";
    }

    @GetMapping("/test5")
    public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
                        @ModelAttribute("sessionBean2") DataBean1 sessionBean2){

        sessionBean1.setData1("문자열6");
        sessionBean1.setData2("문자열7");

        sessionBean2.setData1("문자열8");
        sessionBean2.setData2("문자열9");

        return "test5";
    }

    @GetMapping("/result5")
    public String result5(@SessionAttribute("sessionBean1") DataBean1 bean1,
                          @SessionAttribute("sessionBean2") DataBean1 bean2){
        log.info("bean1.data1 : {}", bean1.getData1());
        log.info("bean1.data2 : {}", bean1.getData2());

        log.info("bean2.data1 : {}", bean2.getData1());
        log.info("bean2.data2 : {}", bean2.getData2());
        return "result5";
    }
}
