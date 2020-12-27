package kr.co.softcampus.config;

import kr.co.softcampus.database.MapperInterface;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.softcampus.controller")
@PropertySource(value = "/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

    @Value("${database.classname}")
    private String db_classname;

    @Value("${database.url}")
    private String db_url;

    @Value("${database.username}")
    private String db_username;

    @Value("${database.password}")
    private String db_password;

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

    //-- 데이터베이스 접속 정보보
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(db_classname);
        dataSource.setUrl(db_url);
        dataSource.setUsername(db_username);
        dataSource.setPassword(db_password);

        return dataSource;
    }

    //-- 접속, 쿼리 관리 객체
    @Bean
    public SqlSessionFactory factory(BasicDataSource dataSource)throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //-- ApplicationContext  주입 필요함.
        // factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        // factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/mappers/*.xml"));
        return factoryBean.getObject();
    }

//    @Bean
//    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    //-- Mapper Bean 정의(쿼리문 실행을 위한 객체)
    //-- 쿼리문을 관리하는 Mapper 를 정의합니다. 이 Mapper 를 주입 받아 쿼리를 실행하게 됩니다.
    @Bean
    public MapperFactoryBean<MapperInterface> test_mapper(SqlSessionFactory factory)throws Exception{
        MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<>(MapperInterface.class);
        factoryBean.setSqlSessionFactory(factory);
        return factoryBean;
    }

}
