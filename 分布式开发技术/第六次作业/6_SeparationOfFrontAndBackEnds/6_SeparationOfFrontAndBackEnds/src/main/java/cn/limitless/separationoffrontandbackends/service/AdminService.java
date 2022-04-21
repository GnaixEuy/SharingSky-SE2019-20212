package cn.limitless.separationoffrontandbackends.service;

import cn.limitless.separationoffrontandbackends.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
public interface AdminService extends IService<Admin> {
    Admin doLogin(String adminName, String password);
}
