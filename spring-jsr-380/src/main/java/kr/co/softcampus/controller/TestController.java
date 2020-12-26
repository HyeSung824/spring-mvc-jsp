package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @Autowired
    MessageSource messageSource;

    @GetMapping("/input_data")
    public String input_data(DataBean1 dataBean1){
        return "input_data";
    }

    @PostMapping("/input_pro")
    public String input_data(@Valid DataBean1 dataBean1, BindingResult result){

        log.info("dataBean1 : {}", dataBean1);

        if(result.hasErrors()){
            return "input_data";
        }
        return "input_success";
    }
}
