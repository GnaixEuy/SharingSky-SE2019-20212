package cn.limitless.springcloud_eureka_server.controller;

import cn.limitless.springcloud_eureka_server.entity.Goods;
import cn.limitless.springcloud_eureka_server.service.GoodsService;
import cn.limitless.springcloud_eureka_server.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * <p>项目： distributed_technology-20212 </p>
 *
 * @author GnaixEuy
 * @date 2022/5/17
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/goods"})
public class GoodsController {

    @Value("${server.port}")
    private String servicePort;
    private GoodsService goodsService;

    @PostMapping(value = {""})
    public ResponseResult<Goods> add(Goods goods) {
        boolean save = this.goodsService.save(goods);
        if (save) {
            ResponseResult<Goods> success = ResponseResult.success(goods);
            success.setMessage("服务端口" + this.servicePort);
            return success;
        } else {
            ResponseResult<Goods> error = ResponseResult.error(null);
            error.setMessage("服务端口" + this.servicePort);
            return error;
        }
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseResult<String> delete(@PathVariable String id) {
        boolean b = this.goodsService.removeById(id);
        if (b) {
            ResponseResult<String> success = ResponseResult.success("删除成功");
            success.setMessage("服务端口" + this.servicePort);
            return success;
        } else {
            return ResponseResult.error("删除失败");
        }
    }

    @PutMapping(value = {""})
    public ResponseResult<Goods> update(Goods goods) {
        this.goodsService.updateById(goods);
        ResponseResult<Goods> success = ResponseResult.success(goods);
        success.setMessage("服务端口" + this.servicePort);
        return success;
    }

    @GetMapping(value = {""})
    public ResponseResult<List<Goods>> search() {
        List<Goods> list = this.goodsService.list();
        ResponseResult<List<Goods>> success = ResponseResult.success(list);
        success.setMessage("服务端口" + this.servicePort);
        return success;
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
