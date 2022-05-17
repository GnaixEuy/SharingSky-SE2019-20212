package cn.limitless.springcloud_eureka_server.dao;

import cn.limitless.springcloud_eureka_server.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * <p>项目： distributed_technology-20212 </p>
 *
 * @author GnaixEuy
 * @date 2022/5/17
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
}
