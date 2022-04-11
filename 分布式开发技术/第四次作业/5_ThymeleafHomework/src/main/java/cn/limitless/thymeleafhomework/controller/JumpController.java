package cn.limitless.thymeleafhomework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/11
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Controller
@RequestMapping(value = {"/jump"})
public class JumpController {

    @RequestMapping(value = {"/innerobj.html"})
    public String innerObj() {
        return "innerobj";
    }

    @RequestMapping(value = {"/toinnerobj.html"})
    public String toInnerObj(Model model) {
        //用来演示#numbers内置对象
        model.addAttribute("num", 18234.567);
        List<Integer> ints = Arrays.asList(100, 120, 90, 180, 70, 110);
        model.addAttribute("numArr", ints);
        //用来演示#strings内置对象
        model.addAttribute("str", "today is a good day");
        //用来演示#date内置对象
        model.addAttribute("mydate", new Date());
        return "innerobj";
    }

    @RequestMapping(value = {"/tomain.html"})
    public String toMain(Model model) {
        model.addAttribute("param1", new Date());
        model.addAttribute("param2", "不太行");
        model.addAttribute("param3", "哈哈哈哈");
        model.addAttribute("param4", "GnaixEuy");
        return "main";
    }
}
