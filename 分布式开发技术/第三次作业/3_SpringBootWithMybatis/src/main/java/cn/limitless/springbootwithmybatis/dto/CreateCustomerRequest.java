package cn.limitless.springbootwithmybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/23
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	private Integer cid;
	private String cName;
	@NotBlank
	@Pattern(regexp = "^[\\d*]{8,12}$", message = "联系电话数据异常")
	private String mobile;
	private String status;

}
