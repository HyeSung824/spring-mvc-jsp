package kr.co.softcampus.controller;

import kr.co.softcampus.beans.UserDataBean;
import kr.co.softcampus.config.SpringConfigClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 5:20
 */
@ExtendWith(value = {SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {SpringConfigClass.class})
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class TestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    TestController testController;

    private UserDataBean bean;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController)
                .setViewResolvers(viewResolver())
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();

        initBean();
    }

    private ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    private UserDataBean initBean(){
        bean = new UserDataBean();
        bean.setUser_id("abcd");
        bean.setUser_name("홍길동 ");
        bean.setUser_pw("1234");
        bean.setUser_postcode("12345");
        bean.setUser_address1("주소 1번 입니다.");
        bean.setUser_address2("주소 2번 입니다.");
        return bean;
    }

    @Test
    @Order(1)
    void test1() throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user_id", "abcd");
        params.add("user_name", "홍길동");
        params.add("user_pw", "1234");
        params.add("user_postcode", "12345");
        params.add("user_address1", "주소 1번 입니다.");
        params.add("user_address2", "주소 2번 입니다.");

        MvcResult mvcResult = mockMvc.perform(get("/test1").params(params))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView mv = mvcResult.getModelAndView();
        String viewName = mv.getViewName();
        Map<String, Object> model = mv.getModel();

        UserDataBean modelBean = (UserDataBean) model.get("userDataBean");

        assertSame(viewName, "test1", "View 이름이 일치하지 않는다.");
        assertSame(modelBean.getUser_id(),  bean.getUser_id());
        assertSame(modelBean.getUser_name(),  bean.getUser_name());
        assertSame(modelBean.getUser_pw(),  bean.getUser_pw());
        assertSame(modelBean.getUser_postcode(),  bean.getUser_postcode());
        assertSame(modelBean.getUser_address1(),  bean.getUser_address1());
        assertSame(modelBean.getUser_address2(),  bean.getUser_address2());
    }

    @Test
    @Order(2)
    void test2() throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user_id", "abcd");
        params.add("user_name", "홍길동");
        params.add("user_pw", "1234");
        params.add("user_postcode", "12345");
        params.add("user_address1", "주소 1번 입니다.");
        params.add("user_address2", "주소 2번 입니다.");

        MvcResult mvcResult = mockMvc.perform(get("/test2").params(params))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView mv = mvcResult.getModelAndView();
        String viewName = mv.getViewName();
        Map<String, Object> model = mv.getModel();

        UserDataBean modelBean = (UserDataBean) model.get("userDataBean");

        assertSame(viewName, "test2", "View 이름이 일치하지 않는다.");
        assertSame(modelBean.getUser_id(),  bean.getUser_id());
        assertSame(modelBean.getUser_name(),  bean.getUser_name());
        assertSame(modelBean.getUser_pw(),  bean.getUser_pw());
        assertSame(modelBean.getUser_postcode(),  bean.getUser_postcode());
        assertSame(modelBean.getUser_address1(),  bean.getUser_address1());
        assertSame(modelBean.getUser_address2(),  bean.getUser_address2());
    }

    @Test
    @Order(3)
    void test3() throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user_id", "abcd");
        params.add("user_name", "홍길동");
        params.add("user_pw", "1234");
        params.add("user_postcode", "12345");
        params.add("user_address1", "주소 1번 입니다.");
        params.add("user_address2", "주소 2번 입니다.");

        MvcResult mvcResult = mockMvc.perform(get("/test3").params(params))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView mv = mvcResult.getModelAndView();
        String viewName = mv.getViewName();
        Map<String, Object> model = mv.getModel();

        UserDataBean modelBean = (UserDataBean) model.get("testBean");

        assertSame(viewName, "test3", "View 이름이 일치하지 않는다.");
        assertSame(modelBean.getUser_id(),  bean.getUser_id());
        assertSame(modelBean.getUser_name(),  bean.getUser_name());
        assertSame(modelBean.getUser_pw(),  bean.getUser_pw());
        assertSame(modelBean.getUser_postcode(),  bean.getUser_postcode());
        assertSame(modelBean.getUser_address1(),  bean.getUser_address1());
        assertSame(modelBean.getUser_address2(),  bean.getUser_address2());
    }

    @Test
    @Order(4)
    void test4() throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user_id", "abcd");
        params.add("user_name", "홍길동");
        params.add("user_pw", "1234");
        params.add("user_postcode", "12345");
        params.add("user_address1", "주소 1번 입니다.");
        params.add("user_address2", "주소 2번 입니다.");

        MvcResult mvcResult = mockMvc.perform(get("/test4").params(params))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView mv = mvcResult.getModelAndView();
        String viewName = mv.getViewName();
        Map<String, Object> model = mv.getModel();

        UserDataBean modelBean = (UserDataBean) model.get("test_user2");

        assertSame(viewName, "test4", "View 이름이 일치하지 않는다.");
        assertSame(modelBean.getUser_id(),  bean.getUser_id());
        assertSame(modelBean.getUser_name(),  bean.getUser_name());
        assertSame(modelBean.getUser_pw(),  bean.getUser_pw());
        assertSame(modelBean.getUser_postcode(),  bean.getUser_postcode());
        assertSame(modelBean.getUser_address1(),  bean.getUser_address1());
        assertSame(modelBean.getUser_address2(),  bean.getUser_address2());
    }
}