### Thymeleaf应用

---

*  根据课上讲的内容，使用Customer表练习Thymeleaf判断与循环的语法的实操。
*  自定义数据练习Thymeleaf的基本内置对象与功能内置对象。
*  仿照课堂上讲的Thymeleaf页面引入案例，定义header.html页面。
*  定义两个<header>，一块内容显示网站信息，一块内容显示用户信息
*  在main引入的时候根据传参来决定具体显示的内容
*  内容中的网站信息和用户信息也根据参数来显示

---

##### 使用技术

> SpringBoot
>
> Spring JPA
>
> Flyway
>
> Thymeleaf

----

#### Controller:

```java
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
```

```java
package cn.limitless.thymeleafhomework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/11
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Controller
@RequestMapping(value = {"/jump"})
public class JumpController {

    @RequestMapping(value = {"/innerobj.html"})
    public String innerObj() {
        return "innerobj";
    }

    @RequestMapping(value = {"/toinnerobj.html"})
    public String toInnerObj(Model model) {
        //用来演示#numbers内置对象
        model.addAttribute("num", 18234.567);
        List<Integer> ints = Arrays.asList(100, 120, 90, 180, 70, 110);
        model.addAttribute("numArr", ints);
        //用来演示#strings内置对象
        model.addAttribute("str", "today is a good day");
        //用来演示#date内置对象
        model.addAttribute("mydate", new Date());
        return "innerobj";
    }

    @RequestMapping(value = {"/tomain.html"})
    public String toMain(Model model) {
        model.addAttribute("param1", new Date());
        model.addAttribute("param2", "不太行");
        model.addAttribute("param3", "哈哈哈哈");
        model.addAttribute("param4", "GnaixEuy");
        return "main";
    }
}
```

---

#### entity:

```java
package cn.limitless.thymeleafhomework.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/10
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customer")
public class Customer {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;

    @ToString.Include
    @Column(name = "cname", nullable = false, length = 20)
    private String cname;

    @ToString.Include
    @Column(name = "mobile", length = 20)
    private String mobile;

    @ToString.Include
    @Column(name = "status", length = 20)
    private String status;

}
```

---

#### 其余代码可见同文件夹下项目