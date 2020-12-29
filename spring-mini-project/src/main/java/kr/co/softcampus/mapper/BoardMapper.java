package kr.co.softcampus.mapper;

import kr.co.softcampus.beans.ContentBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 7:13
 */
public interface BoardMapper {

    @SelectKey(statement = "SELECT CONTENT_SEQ.NEXTVAL FROM DUAL", keyProperty = "content_idx", before = true, resultType = int.class)
    @Insert("INSERT INTO CONTENT_TABLE(" +
            "CONTENT_IDX, CONTENT_SUBJECT, CONTENT_TEXT, " +
            "CONTENT_FILE, CONTENT_WRITER_IDX, CONTENT_BOARD_IDX, " +
            "CONTENT_DATE" +
            ")VALUES(" +
            "#{content_idx}, #{content_subject}, #{content_text}, " +
            "#{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, " +
            "SYSDATE " +
            ")")
    void addContentInfo(ContentBean writeContentBean);

    @Select("SELECT BOARD_INFO_NAME FROM BOARD_INFO_TABLE " +
            "WHERE BOARD_INFO_IDX = #{board_info_idx}")
    String getBoardInfoName(int board_info_idx);

    @Select("SELECT A.CONTENT_IDX, A.CONTENT_SUBJECT, " +
            "B.USER_NAME AS CONTENT_WRITER_NAME, " +
            "TO_CHAR(A.CONTENT_DATE, 'YYYY-MM-DD') AS CONTENT_DATE " +
            "FROM CONTENT_TABLE A, USER_TABLE B " +
            "WHERE A.CONTENT_WRITER_IDX = B.USER_IDX " +
            "AND A.CONTENT_BOARD_IDX = #{board_info_idx} " +
            "ORDER BY A.CONTENT_IDX DESC")
    List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);

    @Select("SELECT B.USER_NAME AS CONTENT_WRITER_NAME, " +
            "TO_CHAR(A.CONTENT_DATE, 'YYYY-MM-DD') AS CONTENT_DATE, " +
            "A.CONTENT_SUBJECT, A.CONTENT_TEXT, A.CONTENT_FILE, A.CONTENT_WRITER_IDX " +
            "FROM CONTENT_TABLE A, USER_TABLE B " +
            "WHERE A.CONTENT_WRITER_IDX = B.USER_IDX " +
            "AND CONTENT_IDX = #{content_idx}")
    ContentBean getContentInfo(int content_idx);

    @Update("UPDATE CONTENT_TABLE " +
            "SET CONTENT_SUBJECT = #{content_subject} " +
            " ,CONTENT_TEXT = #{content_text} " +
            " ,CONTENT_FILE = #{content_file, jdbcType=VARCHAR} " +
            "WHERE CONTENT_IDX = #{content_idx}")
    void modifyContentInfo(ContentBean modifyContentBean);

    @Delete("DELETE FROM CONTENT_TABLE WHERE CONTENT_IDX = #{content_idx}")
    void deleteContentInfo(int content_idx);

    @Select("SELECT COUNT(*) FROM CONTENT_TABLE WHERE CONTENT_BOARD_IDX = #{content_board_idx}")
    int getContentCnt(int content_board_idx);

}
