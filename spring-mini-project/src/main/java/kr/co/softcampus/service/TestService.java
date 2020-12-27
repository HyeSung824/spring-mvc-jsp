package kr.co.softcampus.service;

import kr.co.softcampus.dao.TestDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 8:25
 */
@Service
@Slf4j
public class TestService {

    private TestDAO testDAO;

    @Autowired
    public void setTestDAO(TestDAO testDAO) {
        this.testDAO = testDAO;
    }

    public String testMethod(){
        return testDAO.testDaoMethod();
    }
}
