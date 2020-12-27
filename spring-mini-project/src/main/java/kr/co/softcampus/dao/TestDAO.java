package kr.co.softcampus.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 8:32
 */
@Repository
@Slf4j
public class TestDAO {

    public String testDaoMethod(){
        return "문자열";
    }
}
