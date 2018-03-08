package com.TestTransactions.cashierImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.TestTransactions.cashier.ICashier;
import com.TestTransactions.service.IBookShopService;

@Service("iCashier")
public class CashierImpl implements ICashier {
	@Resource
	private IBookShopService iBookShopService;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void checkOut(String username, List<Integer> isbns) {
		for (int isbn : isbns) {
			iBookShopService.buyBookService(username, isbn);
		}
	}

}
