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