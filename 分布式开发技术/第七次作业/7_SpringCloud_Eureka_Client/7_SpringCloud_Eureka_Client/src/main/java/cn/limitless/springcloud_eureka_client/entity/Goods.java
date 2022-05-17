package cn.limitless.springcloud_eureka_client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * <p>项目： distributed_technology-20212 </p>
 *
 * @author GnaixEuy
 * @date 2022/5/17
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {

    private Integer gid;

    private String gname;

    private String type;

    private Double price;

    private Date date;

}
