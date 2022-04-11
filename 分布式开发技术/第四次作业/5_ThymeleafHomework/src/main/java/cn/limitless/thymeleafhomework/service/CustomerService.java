package cn.limitless.thymeleafhomework.service;

import cn.limitless.thymeleafhomework.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/11
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface CustomerService {

    Page<Customer> page(Pageable pageable);

    Customer add(Customer customer);

    void delete(Customer customer);

    Customer update(Customer customer);

}
