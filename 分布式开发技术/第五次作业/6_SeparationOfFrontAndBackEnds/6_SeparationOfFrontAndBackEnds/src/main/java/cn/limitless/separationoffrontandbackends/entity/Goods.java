package cn.limitless.separationoffrontandbackends.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/21
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Goods {

    @TableId
    private Integer gid;

    @TableField(value = "gname")
    @NotNull(message = "商品名称不能为空")
    private String gname;

    @TableField(value = "type")
    private String type;

    @TableField(value = "price")
    @Min(value = 0, message = "价格不能小于0")
    private Double price;
    
    @TableField(value = "date")
    @Past(message = "商品上架日期不能再未来上架")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
