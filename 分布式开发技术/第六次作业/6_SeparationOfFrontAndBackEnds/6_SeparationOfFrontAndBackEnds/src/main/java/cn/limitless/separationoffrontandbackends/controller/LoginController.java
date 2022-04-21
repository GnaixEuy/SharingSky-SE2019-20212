package cn.limitless.separationoffrontandbackends.controller;

import cn.limitless.separationoffrontandbackends.entity.Admin;
import cn.limitless.separationoffrontandbackends.exception.BizException;
import cn.limitless.separationoffrontandbackends.exception.ExceptionType;
import cn.limitless.separationoffrontandbackends.service.AdminService;
import cn.limitless.separationoffrontandbackends.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@RestController
public class LoginController {

    private AdminService adminService;

    @RequestMapping(value = {"/login"})
    public JsonResult doLogin(String adminname, String password, HttpSession session) {
        System.out.println(adminname + password);
        Admin admin = adminService.doLogin(adminname, password);
        if (admin != null) {
            session.setAttribute("aname", admin.getAname());
            return new JsonResult("欢迎登录本系统");
        } else {
            throw new BizException(ExceptionType.NAME_PASS_ERROR);
        }
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

}
