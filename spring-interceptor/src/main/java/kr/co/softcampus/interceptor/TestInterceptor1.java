package kr.co.softcampus.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 김홍준
 * Date: 2020-12-26
 * Time: 오후 11:00
 */
@Slf4j
public class TestInterceptor1 implements HandlerInterceptor {
    /*
    * Interceptor 구현
    * (현재 자바 버전에는 HandlerInterceptor default 메소드로 구현되있어서
    * HandlerInterceptor, HandlerInterceptorAdapter 별 차이 없다.)
    *
    * - Interceptor 는 HandlerInterceptor 인터페이스를 구현하거나 HandlerInterceptorAdapter 를 상속받은 클래스를 만들고
    * 다음 메서드를 구현합니다.
    * - preHandle : Controller 의 메서드가 호출되기 전 호출됩니다. 이 메서드가 false 를 반환하면 코드의 흐름이 중단됩니다.
    * - postHandle : Controller 의 메서드의 수행이 완료되고 view 처리를 수행하기 전에 호출됩니다.
    * - afterCompletion : view 처리까지 완료되고 응답결과가 브라우저로 전달되기 전에 호출됩니다.
    * */

    //-- false 를 반환하면 요청 처리에 대한 진행이 중단됩니다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TestInterceptor1 - preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("TestInterceptor1 - postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("TestInterceptor1 - afterCompletion");
    }
}
