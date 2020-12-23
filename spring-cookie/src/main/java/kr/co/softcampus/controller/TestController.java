package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/save_cookie")
    public String save_cookie(HttpServletResponse response){

        try {
            String data1 = URLEncoder.encode("문자열1", "UTF-8");
            String data2 = URLEncoder.encode("문자열2", "UTF-8");

            Cookie cookie1 = new Cookie("cookie1", data1);
            Cookie cookie2 = new Cookie("cookie2", data2);

            cookie1.setMaxAge(365 * 24 * 60 * 60);
            cookie2.setMaxAge(365 * 24 * 60 * 60);

            response.addCookie(cookie1);
            response.addCookie(cookie2);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "save_cookie";
    }

    @GetMapping("/load_cookie")
    public String load_cookie(HttpServletRequest request){

        //-- 브라우저는 요청 시 모든 쿠키를 서버에 보낸다.
        try{
            Cookie[] cookies = request.getCookies();

            for(Cookie cookie : cookies){
                log.info("cookie.getValue() : {}", cookie.getValue());
                String str = URLDecoder.decode(cookie.getValue(), "UTF-8");

                if(cookie.getName().equals("cookie1")){
                    log.info("cookie1 : {}", str);
                }else if(cookie.getName().equals("cookie2")){
                    log.info("cookie2 : {}", str);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "load_cookie";
    }

    @GetMapping("/load_cookie2")
    public String load_cookie2(
            @CookieValue("cookie1") String cookie1,
            @CookieValue("cookie2") String cookie2){
        //-- @CookieValue 디코딩까지 완료한 쿠기를 보내줌.
        log.info("cookie1 : {}", cookie1);
        log.info("cookie2 : {}", cookie2);
        return "load_cookie";
    }
}
