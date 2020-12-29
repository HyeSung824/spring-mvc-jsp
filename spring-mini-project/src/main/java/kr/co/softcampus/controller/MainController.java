package kr.co.softcampus.controller;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.ContentBean;
import kr.co.softcampus.service.MainService;
import kr.co.softcampus.service.TopMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 김홍준
 * Date: 2020-12-27
 * Time: 오후 9:18
 */
@Controller
@Slf4j
public class MainController {

    private MainService mainService;
    private TopMenuService topMenuService;

    @Autowired
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    @Autowired
    public void setTopMenuService(TopMenuService topMenuService) {
        this.topMenuService = topMenuService;
    }

    @GetMapping("/main")
    public String main(Model model){

        ArrayList<List<ContentBean>> list = new ArrayList<>();
        for(int idx = 1; idx <= 4; idx++){
            list.add(mainService.getMainList(idx));
        }

        List<BoardInfoBean> board_list = topMenuService.getTopMenuList();

        model.addAttribute("list", list);
        model.addAttribute("board_list", board_list);

        return "main";
    }
}
