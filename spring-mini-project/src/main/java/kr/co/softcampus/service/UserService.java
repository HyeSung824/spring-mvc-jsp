package kr.co.softcampus.service;

import kr.co.softcampus.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 2:01
 */
@Service
@Slf4j
public class UserService {

    private UserDao userDao;

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
}
