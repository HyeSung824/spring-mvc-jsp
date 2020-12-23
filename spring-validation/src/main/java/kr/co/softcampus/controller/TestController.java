package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("input_data")
    public String input_data(){
        return "input_data";
    }

    @PostMapping("input_pro")
    public String input_pro(@Valid DataBean1 dataBean1, BindingResult bindingResult){

        log.info("data1 : {}", dataBean1.getData1());
        log.info("data2 : {}", dataBean1.getData2());

        log.info("BindingResult bindingResult : {}", bindingResult);

        //-- 유효성 검사에서 위반된 부분이 있다면 조건에 진입함.
        if(bindingResult.hasErrors()){
            //-- 유효성 위반 결과를 모두 가져온다.
            for(ObjectError obj : bindingResult.getAllErrors()){
                log.info("메시지 : {}", obj.getDefaultMessage());
                log.info("code : {}", obj.getCode());
                log.info("object name : {}", obj.getObjectName());

                String[] codes = obj.getCodes();
                for(String c1 : codes){
                    log.info("c1 : {}", c1);
                }

                log.info("----------------------------------------");
            }

            return "input_data";
        }

        return "input_success";
    }
}
