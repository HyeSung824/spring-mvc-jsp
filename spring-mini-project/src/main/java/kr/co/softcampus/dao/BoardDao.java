package kr.co.softcampus.dao;

import kr.co.softcampus.beans.ContentBean;
import kr.co.softcampus.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-29
 * Time: 오전 10:29
 */
@Repository
@Slf4j
public class BoardDao {

    private BoardMapper boardMapper;

    @Autowired
    public void setBoardMapper(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public void addContentInfo(ContentBean writeContentBean){
        boardMapper.addContentInfo(writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx){
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
        return boardMapper.getContentList(board_info_idx, rowBounds);
    }

    public ContentBean getContentInfo(int content_idx){
        return boardMapper.getContentInfo(content_idx);
    }

    public void modifyContentInfo(ContentBean modifyContentBean){
        boardMapper.modifyContentInfo(modifyContentBean);
    }

    public void deleteContentInfo(int content_idx){
        boardMapper.deleteContentInfo(content_idx);
    }

    public int getContentCnt(int content_board_idx){
        return boardMapper.getContentCnt(content_board_idx);
    }
}
