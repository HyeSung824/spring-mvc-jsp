package kr.co.softcampus.interceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.service.TopMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 7:52
 */
@Slf4j
public class TopMenuInterceptor implements HandlerInterceptor {

    private TopMenuService topMenuService;

    /*
    * Interceptor 빈을 자동 주입받지 못하기 때문에 Interceptor 등록하는 쪽에서 생성자를 통해
    * 주입해야 함.
    * */
    public void setTopMenuService(TopMenuService topMenuService) {
        this.topMenuService = topMenuService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TopMenuInterceptor - preHandle");
        List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
        request.setAttribute("topMenuList", topMenuList);
        return true;
    }
}
