### SpringBoot整合Mybatis

-----

1. 按照本次课的内容进行SpringBoot和Mybatis的整合。并针对Customer表进行增删改查与分页操作

   > ##### 使用技术栈：
   >
   > * SpringBoot
   > * MybatisPlus
   > * FlyWay
   > * Junit

   Pom.xml如下

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
       <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>2.6.4</version>
           <relativePath/> <!-- lookup parent from repository -->
       </parent>
       <groupId>com.limitless</groupId>
       <artifactId>SpringBootWithMybatis</artifactId>
       <version>0.0.1-SNAPSHOT</version>
       <name>3_SpringBootWithMybatis</name>
       <description>3_SpringBootWithMybatis</description>
       <properties>
           <java.version>11</java.version>
       </properties>
       <dependencies>
           <dependency>
               <groupId>org.flywaydb</groupId>
               <artifactId>flyway-core</artifactId>
           </dependency>
           <dependency>
               <groupId>com.baomidou</groupId>
               <artifactId>mybatis-plus-boot-starter</artifactId>
               <version>3.5.1</version>
           </dependency>
   
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
               <scope>runtime</scope>
               <optional>true</optional>
           </dependency>
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <scope>runtime</scope>
           </dependency>
           <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <optional>true</optional>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-test</artifactId>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-validation</artifactId>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
       </dependencies>
   
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
                   <configuration>
                       <excludes>
                           <exclude>
                               <groupId>org.projectlombok</groupId>
                               <artifactId>lombok</artifactId>
                           </exclude>
                       </excludes>
                   </configuration>
               </plugin>
           </plugins>
           <resources>
               <resource>
                   <directory>src/main/java</directory>
                   <includes>
                       <include>**/*.properties</include>
                       <include>**/*.xml</include>
                   </includes>
                   <filtering>false</filtering>
               </resource>
               <resource>
                   <directory>src/main/resources</directory>
                   <includes>
                       <include>**/*.*</include>
                   </includes>
               </resource>
           </resources>
       </build>
   
   </project>
   ```

   Application.yml

   ```yaml
   spring:
     flyway:
       enabled: true
       encoding: UTF-8
       locations: classpath:db/migration
       sqlMigrationPrefix: V
       sqlMigrationSeparator: __
       sqlMigrationSuffixes: .sql
       validateOnMigrate: true
       baselineOnMigrate: true
     datasource:
       url: jdbc:mysql://localhost:3306/homework?characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true
       username: root
       password: 123456
       driver-class-name: com.mysql.cj.jdbc.Driver
     sql:
       init:
         encoding: utf-8
   mybatis-plus:
     mapper-locations: classpath:cn/limitless/springbootwithmybatis/dao/impl/*.xml
   ```

   Test.java

   ```java
   package cn.limitless.springbootwithmybatis.dao;
   
   import cn.limitless.springbootwithmybatis.entity.Customer;
   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   import org.springframework.transaction.annotation.Transactional;
   
   /**
    * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
    *
    * @author GnaixEuy
    * @date 2022/3/22
    * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
    */
   @SpringBootTest
   @Transactional
   class CustomerDaoTest {
   
   	@Autowired
   	private CustomerDao customerDao;
   
   	@Test
   	public void insert() {
   		final Customer customer = new Customer();
   		customer.setCid(2333);
   		customer.setCName("小丑");
   		customer.setMobile("2333333333");
   		customer.setStatus("enable");
   		final int insertResult = this.customerDao.insert(customer);
   		Assertions.assertEquals(1, insertResult);
   	}
   
   	@Test
   	public void delete() {
   		final int deleteResult = this.customerDao.deleteById("1");
   		Assertions.assertEquals(1, deleteResult);
   	}
   
   	@Test
   	public void update() {
   		final Customer customer = this.customerDao.selectById("1");
   		customer.setCName("歌坛小丑");
   		final int updateResult = this.customerDao.updateById(customer);
   		Assertions.assertEquals(1, updateResult);
   	}
   
   	@Test
   	public void selectList() {
   		this.customerDao.selectList(null).forEach(System.out::println);
   	}
   
   }
   ```

   其余代码见附带文件

   实验结果

   <img src="SpringBoot整合Mybatis.assets/截屏2022-03-23 09.44.05.png" alt="截屏2022-03-23 09.44.05" style="zoom:50%;" />

   ----

   2. 按照本次课的内容对Customer类的mobile属性进行非空校验与长度校验

      Controller.java

      ```java
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
      ```

      Vo.java

      ```java
      package cn.limitless.springbootwithmybatis.vo;
      
      import lombok.AllArgsConstructor;
      import lombok.Data;
      import lombok.NoArgsConstructor;
      
      /**
       * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
       *
       * @author GnaixEuy
       * @date 2022/3/22
       * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
       */
      @Data
      @AllArgsConstructor
      @NoArgsConstructor
      public class CustomerVo {
      
      	private Integer cid;
      	private String cName;
      	private String mobile;
      	private String status;
      
      }
      ```

      Dto.java

      ```java
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
      ```

      #### 实验结果

      ##### 分页

      <img src="SpringBoot整合Mybatis.assets/截屏2022-03-23 09.54.21.png" alt="截屏2022-03-23 09.54.21" style="zoom:50%;" />

      ##### 添加成功

      <img src="SpringBoot整合Mybatis.assets/截屏2022-03-23 09.43.20.png" alt="截屏2022-03-23 09.43.20" style="zoom:50%;" />

      ##### 添加失败

      <img src="SpringBoot整合Mybatis.assets/截屏2022-03-23 09.42.40.png" alt="截屏2022-03-23 09.42.40" style="zoom:50%;" />

      <img src="SpringBoot整合Mybatis.assets/截屏2022-03-23 09.54.04.png" alt="截屏2022-03-23 09.54.04" style="zoom:50%;" />

---

