package cn.limitless.separationoffrontandbackends.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public class JsonResult<T> {

    public static final Integer SUCCESS = 0;

    private String message = "";
    private Integer state;
    private T data;
    private List<T> datas;
    /**
     * 分页特化处理
     */
    private Page<T> pagedatas;

    /**
     * total和rows是专门个bootstrap table做适配用的
     */
    private long total;
    private List<T> rows;

    public JsonResult(String message) {
        this.state = JsonResult.SUCCESS;
        this.message = message;
    }

    public JsonResult(String message, Integer state) {
        this.message = message;
        this.state = state;
    }

    /**
     * 处理对象数据
     */
    public JsonResult(T data) {
        this.state = SUCCESS;
        this.data = data;
    }

    public JsonResult(String message, T data) {
        this.state = SUCCESS;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }


    /**
     * 处理集合数据
     */
    public JsonResult(List<T> datas) {
        this.state = SUCCESS;
        this.datas = datas;
    }

    public JsonResult(String message, List<T> datas) {
        this.state = SUCCESS;
        this.message = message;
        this.datas = datas;
    }

    public JsonResult(int state, String message, List<T> datas) {
        this.state = state;
        this.message = message;
        this.datas = datas;
    }


}
