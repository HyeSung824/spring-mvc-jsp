package kr.co.softcampus.config;

import kr.co.softcampus.interceptor.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.softcampus.controller")
public class ServletAppContext implements WebMvcConfigurer {

    //-- Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        TestInterceptor1 interceptor1 = new TestInterceptor1();
        TestInterceptor2 interceptor2 = new TestInterceptor2();
        TestInterceptor3 interceptor3 = new TestInterceptor3();
        TestInterceptor4 interceptor4 = new TestInterceptor4();
        TestInterceptor5 interceptor5 = new TestInterceptor5();
        TestInterceptor6 interceptor6 = new TestInterceptor6();
        TestInterceptor7 interceptor7 = new TestInterceptor7();
        TestInterceptor8 interceptor8 = new TestInterceptor8();

        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(interceptor1);
        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(interceptor2);
        InterceptorRegistration interceptorRegistration3 = registry.addInterceptor(interceptor3);
        InterceptorRegistration interceptorRegistration4 = registry.addInterceptor(interceptor4);
        InterceptorRegistration interceptorRegistration5 = registry.addInterceptor(interceptor5);
        InterceptorRegistration interceptorRegistration6 = registry.addInterceptor(interceptor6);
        InterceptorRegistration interceptorRegistration7 = registry.addInterceptor(interceptor7);
        InterceptorRegistration interceptorRegistration8 = registry.addInterceptor(interceptor8);

        interceptorRegistration1.addPathPatterns("/test1");
        interceptorRegistration2.addPathPatterns("/test1");

        interceptorRegistration3.addPathPatterns("/test2");

        interceptorRegistration4.addPathPatterns("/test1", "/test2");

        interceptorRegistration5.addPathPatterns("/sub1/test3", "/sub1/test4");

        //-- 패턴으로 등록하기
        //-- * : 이름 하나를 의미하며 글자수, 글자 등 제한이 없다.
        //-- ? : 글자 하나를 의미한다.
        //-- ** : 하위 이름까지 포함하여 글자수, 글자 등 제한이 없다.
        interceptorRegistration6.addPathPatterns("/*");
        interceptorRegistration7.addPathPatterns("/sub1/*");
        interceptorRegistration8.addPathPatterns("/**");

        //- excludePathPatterns : interceptor 제외할 패턴
        interceptorRegistration8.excludePathPatterns("/*");
    }
}
