package cn.limitless.separationoffrontandbackends.dao;

import cn.limitless.separationoffrontandbackends.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <img src='https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg'/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/18
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Mapper
public interface CustomerDao extends BaseMapper<Customer> {
}
