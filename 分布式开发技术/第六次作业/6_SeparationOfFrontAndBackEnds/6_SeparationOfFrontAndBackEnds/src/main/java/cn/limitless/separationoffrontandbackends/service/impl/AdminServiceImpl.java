package cn.limitless.separationoffrontandbackends.service.impl;

import cn.limitless.separationoffrontandbackends.dao.AdminDao;
import cn.limitless.separationoffrontandbackends.entity.Admin;
import cn.limitless.separationoffrontandbackends.service.AdminService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    private AdminDao adminDao;

    @Override
    public Admin doLogin(String adminName, String password) {
        return this.adminDao.selectOne(
                Wrappers.<Admin>lambdaQuery()
                        .eq(Admin::getAname, adminName)
                        .eq(Admin::getPassword, password)
        );
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
