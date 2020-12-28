package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오후 1:55
 */
public interface UserMapper {

    @Select("SELECT USER_NAME FROM USER_TABLE WHERE USER_ID = #{user_id}")
    String checkUserIdExist(String user_id);

}
