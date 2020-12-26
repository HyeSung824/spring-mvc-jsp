package kr.co.softcampus.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오전 12:20
 */
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(NullPointerException.class)
    public String handleException(){
        return "error2";
    }
}
