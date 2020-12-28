package kr.co.softcampus.mapper;

import kr.co.softcampus.beans.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 1:55
 */
public interface UserMapper {

    @Select("SELECT USER_NAME FROM USER_TABLE WHERE USER_ID = #{user_id}")
    String checkUserIdExist(String user_id);

    @Insert(
        "INSERT INTO USER_TABLE (USER_IDX, USER_NAME, USER_ID, USER_PW) " +
        "VALUES(USER_SEQ.NEXTVAL, #{user_name}, #{user_id}, #{user_pw})")
    void addUserInfo(UserBean userBean);

    @Select("SELECT USER_IDX, USER_NAME " +
            "FROM USER_TABLE " +
            "WHERE USER_ID = #{user_id} AND USER_PW = #{user_pw}")
    UserBean getLoginUserInfo(UserBean tempLoginUserBean);

}
