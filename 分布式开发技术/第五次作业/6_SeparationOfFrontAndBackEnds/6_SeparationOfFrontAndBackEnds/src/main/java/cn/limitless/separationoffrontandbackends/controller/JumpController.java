package cn.limitless.separationoffrontandbackends.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Controller
public class JumpController {

    @RequestMapping(value = {"/main"})
    public String sendMain() {
        return "main";
    }
}
