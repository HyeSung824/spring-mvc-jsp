package kr.co.softcampus.validator;

import kr.co.softcampus.beans.DataBean1;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by 김홍준
 * Date: 2020-12-26
 * Time: 오후 6:00
 */
public class DataBean1Validator implements Validator {
    /*
    * ValidateUtils
    * 지정된 값에 대해 유효성 검사를 하는 메서드
    * rejectIfEmpty(error객체, “프로퍼티이름“, “코드이름“) : 값이 비어 있는지 확인합니다. 공백은 글자로 취급합니다.
    *
    * rejectIfEmptyOrWhitespace(error객체, “프로퍼티이름“, “코드이름“) : 값이 비어 있거나 공백으로만 구성되어 있는지 확인합니다.
    * 입력값에 문제가 있다면 error 객체에 오류정보를 저장합니다.
    * 사용할 오류 메시지는 “코드이름.bean객체이름.프로퍼티이름”으로 구성됩니다.
    *
    * rejectValue
    * 유효성 조건을 직접 만들어 검사할 때 사용합니다.
    * If 문으로 유효성 검사를 해주고 위배시 rejectValue 를 통해 오류 정보를 지정합니다..
    * rejectValue( “프로퍼티이름“, “코드이름“)
    * 입력값에 문제가 있다면 error 객체에 오류정보를 저장합니다.
    * 사용할 오류 메시지는 “코드이름.bean객체이름.프로퍼티이름”으로 구성됩니다.
    * */
    @Override
    public boolean supports(Class<?> clazz) {
        return DataBean1.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");

        DataBean1 bean1 = (DataBean1)target;
        String data2 = bean1.getData2();
        String data3 = bean1.getData3();

        if(data2.length() > 10){
            errors.rejectValue("data2", "error4");
        }

        if(!data3.contains("@")){
            errors.rejectValue("data3", "error5");
        }
    }
}
