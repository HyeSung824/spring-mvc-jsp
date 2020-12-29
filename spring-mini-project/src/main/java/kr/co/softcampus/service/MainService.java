package kr.co.softcampus.service;

import kr.co.softcampus.beans.ContentBean;
import kr.co.softcampus.dao.BoardDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-29
 * Time: 오후 6:11
 */
@Service
@Slf4j
public class MainService {

    private BoardDao boardDao;

    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<ContentBean> getMainList(int board_info_idx){
        RowBounds rowBounds = new RowBounds(0, 5);
        return boardDao.getContentList(board_info_idx, rowBounds);
    }
}
