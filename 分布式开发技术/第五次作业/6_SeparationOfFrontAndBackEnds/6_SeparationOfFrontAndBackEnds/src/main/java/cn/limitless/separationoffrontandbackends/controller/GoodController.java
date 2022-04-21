package cn.limitless.separationoffrontandbackends.controller;

import cn.limitless.separationoffrontandbackends.entity.Goods;
import cn.limitless.separationoffrontandbackends.exception.BizException;
import cn.limitless.separationoffrontandbackends.exception.ExceptionType;
import cn.limitless.separationoffrontandbackends.service.GoodsService;
import cn.limitless.separationoffrontandbackends.vo.JsonResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
public class GoodController {
    private GoodsService goodsService;

    @PostMapping("goods")
    public JsonResult addGoods(@RequestBody @Valid Goods goods, BindingResult br) {
        if (br.hasErrors()) {
            throw new BizException(ExceptionType.CHECK_ERROR);
        } else {
            goodsService.save(goods);
            return new JsonResult("添加成功");
        }
    }

    @PutMapping("goods")
    public JsonResult editGoods(Goods goods) {
        goodsService.updateById(goods);
        return new JsonResult("修改成功");
    }

    @DeleteMapping("goods")
    public JsonResult removeGoods(@RequestBody List<Goods> list) {
        goodsService.removeBatchByIds(list);
        return new JsonResult("删除成功");
    }

    @GetMapping("goods/less/{price}/{type}")
    public JsonResult<Goods> findGoods(@PathVariable double price, @PathVariable String type) {
        Goods one = this.goodsService
                .getOne(Wrappers.<Goods>lambdaQuery()
                        .le(Goods::getType, type)
                        .le(Goods::getPrice, price)
                );
        return new JsonResult<>(one);

    }

    @GetMapping("goods/page/{pageNum}/{pageSize}")
    public JsonResult<Goods> findAllGoods(@PathVariable int pageNum, @PathVariable int pageSize) {
        Page<Goods> page = this.goodsService.page(new Page<>(pageNum, pageSize));
        return new JsonResult<>(page.getRecords());
    }


    @GetMapping(value = {"goods"})
    public JsonResult findAllGoods(int pageNum, int pageSize, String sort, String order, String gname, String type) {
        Page<Goods> page = this.goodsService.page(new Page<>(pageNum, pageSize), Wrappers.<Goods>lambdaQuery()
                .like(Goods::getGname, gname)
                .like(Goods::getType, type)
                .orderByAsc(Goods::getGid));
        JsonResult jsonResult = new JsonResult<>();
        jsonResult.setTotal(page.getTotal());
        jsonResult.setRows(page.getRecords());
        jsonResult.setDatas(page.getRecords());
        jsonResult.setPagedatas(page);
        return jsonResult;
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
