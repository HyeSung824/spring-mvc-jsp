package kr.co.softcampus.dao;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.mapper.TopMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 7:44
 */
@Repository
public class TopMenuDao {

    private TopMenuMapper topMenuMapper;

    @Autowired
    public void setTopMenuMapper(TopMenuMapper topMenuMapper) {
        this.topMenuMapper = topMenuMapper;
    }

    public List<BoardInfoBean> getTopMenuList(){
        return topMenuMapper.getTopMenuList();
    }
}
