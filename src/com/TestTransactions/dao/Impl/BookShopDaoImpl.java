package com.TestTransactions.dao.Impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TestTransactions.dao.IBookShopDao;

@Repository("iBookShopDao")
public class BookShopDaoImpl implements IBookShopDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int findBookPriceByIsbn(int isbn) {
		String sql = "select price from book where isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	@Override
	public void updateBookstockByIsbn(int isbn) {
		String sql2 = "select stock from book_stock  where isbn=?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if (stock <= 0) {
			throw new RuntimeException("库存不够");
		}

		String sql = "update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserBalance(String username, int price) {
		String sql2 = "select balance from account  where username=?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if (balance < price) {
			throw new RuntimeException("钱不够");
		}

		String sql = "update account set balance=balance-? where username=?";
		jdbcTemplate.update(sql, price, username);
	}

}
