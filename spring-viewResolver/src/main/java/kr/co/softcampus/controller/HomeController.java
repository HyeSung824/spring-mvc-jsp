package kr.co.softcampus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @GetMapping("test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    public String test2(HttpServletRequest request){

        request.setAttribute("data1", 100);
        request.setAttribute("data2", 200);

        return "test2";
    }

    @GetMapping("test3")
    public String test3(Model model){

        model.addAttribute("data1",300);
        model.addAttribute("data2",400);

        return "test3";
    }

    @GetMapping("test4")
    public ModelAndView test4(ModelAndView mv){

        mv.addObject("data1", 300);
        mv.addObject("data2", 400);
        mv.setViewName("test4");

        return mv;
    }

}
