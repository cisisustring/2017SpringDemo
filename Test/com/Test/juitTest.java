package com.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.Service.IAdminService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class juitTest {

	@Resource
	private IAdminService asi;
	@Resource(name="dateSource")
	private ComboPooledDataSource dateSource;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	public void test1() {
		asi.showDao();
	}

	@Test
	public void testDataSource() throws Exception {
		System.out.println(dateSource.getConnection());
	}
	@Test
	public void testJdbcTemplate(){
		String sql="select user_name from imooc_goddess where id=?";
		System.out.println(jdbcTemplate.queryForObject(sql, String.class, 3));
		/*sql="insert into imooc_goddess(user_name)values(?) ";
		jdbcTemplate.update(sql, "我知道");
		sql="delete from imooc_goddess where user_name=? ";
		jdbcTemplate.update(sql, "我知道");*/
	}
}
