package kr.co.softcampus.controller;

import kr.co.softcampus.config.SpringConfigClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by 김홍준
 * Date: 2020-12-20
 * Time: 오후 10:26
 */
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {SpringConfigClass.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); //-- Mockito 어노테이션이 선언된 변수들은 객체를 만든다.
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setViewResolvers(viewResolver())
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print()).build();
    }

    private ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Test
    @Order(1)
    public void test1()throws Exception{
        mockMvc.perform(get("/test1"))
                .andExpect(status().isOk())
                .andExpect(view().name("test1"));
    }

    @Test
    @Order(2)
    public void test2()throws Exception{
        mockMvc.perform(get("/test3"))
                .andExpect(status().isOk())
                .andExpect(view().name("test3"))
                .andExpect((ResultMatcher) model().attribute("data1", 300))
                .andExpect((ResultMatcher) model().attribute("data2", 400));
    }

    @Test
    @Order(3)
    public void test3()throws Exception{
        mockMvc.perform(get("/test4"))
                .andExpect(status().isOk())
                .andExpect(view().name("test4"))
                .andExpect((ResultMatcher) model().attribute("data1", 300))
                .andExpect((ResultMatcher) model().attribute("data2", 400));
    }
}