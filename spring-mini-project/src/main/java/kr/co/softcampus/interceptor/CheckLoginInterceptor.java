package kr.co.softcampus.interceptor;

import kr.co.softcampus.beans.UserBean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 7:19
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    private UserBean loginUserBean;

    public CheckLoginInterceptor(UserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!loginUserBean.isUserLogin()){
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/user/not_login");
            return false;
        }

        return true;
    }
}
