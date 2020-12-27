package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 3:29
 */
@RestController
public class RestTestController {

    @GetMapping("/test2")
    public ResponseEntity<List<DataBean>> test2(){

        DataBean bean1 = new DataBean("문자열1", 100, 11.11, false);
        DataBean bean2 = new DataBean("문자열2", 200, 22.22, true);
        DataBean bean3 = new DataBean("문자열3", 300, 33.33, false);

        List<DataBean> list = List.of(bean1, bean2, bean3);

        ResponseEntity<List<DataBean>> entity = new ResponseEntity<>(list, HttpStatus.OK);

        return entity;
    }
}
