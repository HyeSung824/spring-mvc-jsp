package kr.co.softcampus.service;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.dao.TopMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 7:49
 */
@Service
public class TopMenuService {

    private TopMenuDao topMenuDao;

    @Autowired
    public void setTopMenuDao(TopMenuDao topMenuDao) {
        this.topMenuDao = topMenuDao;
    }

    public List<BoardInfoBean> getTopMenuList(){
        return topMenuDao.getTopMenuList();
    }
}
