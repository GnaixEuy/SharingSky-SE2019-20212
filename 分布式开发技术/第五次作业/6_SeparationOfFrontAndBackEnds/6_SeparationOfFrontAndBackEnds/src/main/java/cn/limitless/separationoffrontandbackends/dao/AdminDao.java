package cn.limitless.separationoffrontandbackends.dao;

import cn.limitless.separationoffrontandbackends.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Mapper
public interface AdminDao extends BaseMapper<Admin> {
}
