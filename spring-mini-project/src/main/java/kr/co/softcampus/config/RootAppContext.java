package kr.co.softcampus.config;

import kr.co.softcampus.beans.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

//-- 프로젝트 작업시 사용할 bean 정의하는 클래스
@Configuration
public class RootAppContext {
    /*
    * @SessionScope
    * Bean 을 정의할 때 session scope 로 정의하면 브라우저가
    * 서버에 최초의 요청을 보낼 때 Bean 객체가 주입됩니다.
    * 주입된 Bean 은 주입만 이루어지는 것이므로 session 영역에 저장되지는 않습니다.
    * */
    @Bean("loginUserBean")
    @SessionScope
    public UserBean loginUserBean(){
        return new UserBean();
    }

}
