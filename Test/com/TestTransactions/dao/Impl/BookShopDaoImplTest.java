package com.TestTransactions.dao.Impl;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.TestTransactions.cashier.ICashier;
import com.TestTransactions.service.IBookShopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookShopDaoImplTest {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private IBookShopService iBookShopService;
	
	@Resource
	private ICashier iCashier;
	@Test
	public void testbuyBookService(){
		iBookShopService.buyBookService("aa", 1001);
	}

	@Test
	public void testcheckOut(){
		iCashier.checkOut("aa", Arrays.asList(1001,1002));
	}
	
	@Test
	public void testFindBookPriceByIsbn() {
		String sql = "select price from book where isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, 1002);
		System.out.println(price);
	}

	@Test
	public void testUpdateBookstockByIsbn() {
		String sql2 = "select stock from book_stock  where isbn=?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, 1001);
		if (stock <= 0) {
			throw new RuntimeException("¿â´æ²»×ã");
		}

		String sql = "update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql, 1001);
	}

	@Test
	public void testUpdateUserBalance() {
		String sql2 = "select balance from account  where username=?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, "aa");
		if (balance < 80) {
			throw new RuntimeException("Óà¶î²»×ã");
		}

		String sql = "update account set balance=balance-? where username=?";
		jdbcTemplate.update(sql, 80, "aa");
	}

}
