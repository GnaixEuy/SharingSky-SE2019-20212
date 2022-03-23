package cn.limitless.springbootwithmybatis.controller;

import cn.limitless.springbootwithmybatis.dao.CustomerDao;
import cn.limitless.springbootwithmybatis.dto.CreateCustomerRequest;
import cn.limitless.springbootwithmybatis.entity.Customer;
import cn.limitless.springbootwithmybatis.vo.CustomerVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/22
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class CustomerDaoController {

	/* 删改查在单元测试里面 */

	private final CustomerDao customerDao;

	@PostMapping(value = "/add")
	public CustomerVo add(@Validated @RequestBody CreateCustomerRequest createCustomerRequest) {
		System.out.println(createCustomerRequest.getCName());
		System.out.println(createCustomerRequest.getMobile());
		//手动mapper
		final Customer customer = new Customer(createCustomerRequest.getCid(),
				createCustomerRequest.getCName(),
				createCustomerRequest.getMobile(),
				createCustomerRequest.getStatus());
		final int insert = this.customerDao.insert(customer);
		if (insert == 1) {
			//手动mapper
			return new CustomerVo(customer.getCid(),
					customer.getCName(),
					customer.getMobile(),
					customer.getStatus());
		} else {
			throw new RuntimeException("业务错误");
		}
	}

	@GetMapping(value = {"/"})
	public Page<Customer> search(Page<Customer> page) {
		return this.customerDao.selectPage(page, null);
	}

}
