package kr.co.softcampus.mapper;

import kr.co.softcampus.beans.BoardInfoBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 7:40
 */
public interface TopMenuMapper {

    @Select("SELECT \n" +
            "\tBOARD_INFO_IDX, BOARD_INFO_NAME \n" +
            "FROM BOARD_INFO_TABLE \n" +
            "ORDER BY BOARD_INFO_IDX ASC")
    List<BoardInfoBean> getTopMenuList();
}
