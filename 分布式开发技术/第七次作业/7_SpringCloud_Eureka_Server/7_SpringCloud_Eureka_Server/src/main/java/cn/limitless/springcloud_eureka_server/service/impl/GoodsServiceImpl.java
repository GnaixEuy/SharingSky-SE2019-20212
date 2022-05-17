package cn.limitless.springcloud_eureka_server.service.impl;

import cn.limitless.springcloud_eureka_server.dao.GoodsDao;
import cn.limitless.springcloud_eureka_server.entity.Goods;
import cn.limitless.springcloud_eureka_server.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * <p>项目： distributed_technology-20212 </p>
 *
 * @author GnaixEuy
 * @date 2022/5/17
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {
}
