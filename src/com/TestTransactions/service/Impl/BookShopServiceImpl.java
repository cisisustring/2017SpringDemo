package com.TestTransactions.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.TestTransactions.dao.IBookShopDao;
import com.TestTransactions.service.IBookShopService;

@Service("iBookShopService")
public class BookShopServiceImpl implements IBookShopService {
	@Resource
	private IBookShopDao iBookShopDao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void buyBookService(String username, int isbn) {
		// 1查找价格,根据isbn
		int price = iBookShopDao.findBookPriceByIsbn(isbn);
		// 2更新书库存,根据isbn
		iBookShopDao.updateBookstockByIsbn(isbn);
		// 3更新客人的余额,根据username和price
		iBookShopDao.updateUserBalance(username, price);
	}

}
