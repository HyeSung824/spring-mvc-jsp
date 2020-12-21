package kr.co.softcampus.controller;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.KeyValueBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-21
 * Time: 오후 1:56
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("test1")
    public String test1(DataBean bean, Model model){
        bean.setA1("data2");
        bean.setA2("data2");
        bean.setA3("data3");
        bean.setA4("data2");

        String[] check_list = {"data1", "data3"};
        bean.setA5(check_list);
        bean.setA6(check_list);
        bean.setA7(check_list);
        bean.setA8(check_list);

        bean.setA9("data2");
        bean.setA10("data2");
        bean.setA11("data2");
        bean.setA12("data2");

        String[] data_list1 = {"data1", "data2", "data3"};
        List<String> data_list2 = List.of("data1", "data2", "data3");

        KeyValueBean key_bean1 = new KeyValueBean();
        KeyValueBean key_bean2 = new KeyValueBean();
        KeyValueBean key_bean3 = new KeyValueBean();

        key_bean1.setKey("항목1");
        key_bean1.setValue("data1");

        key_bean2.setKey("항목2");
        key_bean2.setValue("data2");

        key_bean3.setKey("항목3");
        key_bean3.setValue("data3");

        List<KeyValueBean> data_list3 = List.of(key_bean1, key_bean2, key_bean3);

        model.addAttribute("data_list1", data_list1);
        model.addAttribute("data_list2", data_list2);
        model.addAttribute("data_list3", data_list3);

        return "test1";
    }
}
