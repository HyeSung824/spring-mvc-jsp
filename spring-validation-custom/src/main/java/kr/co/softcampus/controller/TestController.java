package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.validator.DataBean1Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
    /*
    * Validator 인터페이스 구현
    * - Validator 인터페이스 구현해야 한다.
    * - supports : 유효성 검사할 데이터를 가지고 있는 객체가 유효성 검사가 가능한지 확인합니다.
    * - validate : 유효성 검사를 하는 메서드
    * - Validator를 컨트롤러에서 등록
    * - 사용할 Validator가 하나면 setValidator, 한 개 이상이면 addValidators 메서드를 사용한다.
    * */

    @Autowired
    MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DataBean1Validator validator1 = new DataBean1Validator();
        //-- binder.setValidator(validator1);
        binder.addValidators(validator1); //-- validator 가 여러개일때 사용한다.
    }

    @GetMapping("/input_data")
    public String input_data(DataBean1 dataBean1){
        return "input_data";
    }

    @PostMapping("/input_pro")
    public String input_pro(@Valid DataBean1 dataBean1, BindingResult result){
        if(result.hasErrors()){
            return "input_data";
        }
        return "input_success";
    }
}
