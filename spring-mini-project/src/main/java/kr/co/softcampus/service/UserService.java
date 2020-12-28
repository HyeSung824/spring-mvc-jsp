package kr.co.softcampus.service;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 2:01
 */
@Service
@Slf4j
public class UserService {

    private UserDao userDao;

    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserIdExist(String user_id){

        String user_name = userDao.checkUserIdExist(user_id);
        if(user_name == null){
            return true;
        }

        return false;
    }

    public void addUserInfo(UserBean joinUserBean){
        userDao.addUserInfo(joinUserBean);
    }

    public void getLoginUserInfo(UserBean tempLoginUserBean){
        UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
        if(tempLoginUserBean2 != null){
            //-- 로그인 성공
            loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
            loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
            loginUserBean.setUserLogin(true);
        }
    }
}
