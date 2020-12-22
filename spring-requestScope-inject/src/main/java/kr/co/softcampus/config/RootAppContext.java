package kr.co.softcampus.config;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

//-- 프로젝트 작업시 사용할 bean 정의하는 클래스
@Configuration
public class RootAppContext {

    //-- @RequestScope : 요청이 올 때마다 Bean 생성
    @Bean
    @RequestScope
    public DataBean1 dataBean1(){
        return new DataBean1();
    }

    @Bean(value = "requestBean2")
    @RequestScope
    public DataBean2 dataBean2(){
        return new DataBean2();
    }
}
