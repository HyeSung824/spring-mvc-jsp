package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 11:11
 */
@Controller
@Slf4j
//@PropertySource(value = "/WEB-INF/properties/data1.properties", encoding = "UTF-8")
//@PropertySource(value = "/WEB-INF/properties/data2.properties", encoding = "UTF-8")
//@PropertySource(value = {
//        "/WEB-INF/properties/data1.properties",
//        "/WEB-INF/properties/data2.properties"
//}, encoding = "UTF-8")
@PropertySources({
    @PropertySource(value = "/WEB-INF/properties/data1.properties", encoding = "UTF-8"),
    @PropertySource(value = "/WEB-INF/properties/data2.properties", encoding = "UTF-8")
})
public class TestController {

    /*
    * @PropertySource(단일 파일), @@PropertySources(여러 파일)
    * - 사용할 properties 파일을 지정한다.
    * - 하나 혹은 다수의 파일을 지정할 수 있다.
    *
    * 값을 가져다 쓸 때는 @Value 를 사용하여 값을 주입 받을 수 있다.
    * @Value("${aaa.a1}")
    * private itn a1;
    * */

    @Value("${aaa.a1}")
    private int a1;

    @Value("${aaa.a2}")
    private String a2;

    @Value("${bbb.b1}")
    private int b1;

    @Value("${bbb.b2}")
    private String b2;

    @Value("${ccc.c1}")
    private int c1;

    @Value("${ccc.c2}")
    private String c2;

    @Value("${ddd.d1}")
    private int d1;

    @Value("${ddd.d2}")
    private String d2;

    @GetMapping("/test1")
    public String test1(){

        log.info("a1 : {}", a1);
        log.info("a2 : {}", a2);
        log.info("b1 : {}", b1);
        log.info("b2 : {}", b2);

        log.info("c1 : {}", c1);
        log.info("c2 : {}", c2);
        log.info("d1 : {}", d1);
        log.info("d2 : {}", d2);

        return "test1";
    }
}
