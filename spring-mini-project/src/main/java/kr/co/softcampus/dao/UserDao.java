package kr.co.softcampus.dao;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 1:59
 */
@Repository
@Slf4j
public class UserDao {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String checkUserIdExist(String user_id){
        return userMapper.checkUserIdExist(user_id);
    }

    public void addUserInfo(UserBean userBean){
        userMapper.addUserInfo(userBean);
    }

    public UserBean getLoginUserInfo(UserBean tempLoginUserBean){
        return userMapper.getLoginUserInfo(tempLoginUserBean);
    }

    public UserBean getModifyUserInfo(int user_idx){
        return userMapper.getModifyUserInfo(user_idx);
    }

    public void modifyUserInfo(UserBean modifyUserBean){
        userMapper.modifyUserInfo(modifyUserBean);
    }
}
