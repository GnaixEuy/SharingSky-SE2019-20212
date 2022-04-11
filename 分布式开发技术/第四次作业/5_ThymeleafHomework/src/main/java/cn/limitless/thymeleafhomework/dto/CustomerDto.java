package cn.limitless.thymeleafhomework.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/11
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class CustomerDto implements Serializable {
    private final Integer id;
    private final String cname;
    private final String mobile;
    private final String status;
}
