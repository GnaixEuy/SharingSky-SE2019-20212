package cn.limitless.thymeleafhomework.controller;

import cn.limitless.thymeleafhomework.entity.Customer;
import cn.limitless.thymeleafhomework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/10
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(value = {"/page"})
    public String page(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable, HttpServletRequest httpServletRequest) {
        Page<Customer> page = this.customerService.page(pageable);
        page.getContent().forEach(System.out::println);
        httpServletRequest.getServletContext().setAttribute("customerData", page);
        return "customers";
    }


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
