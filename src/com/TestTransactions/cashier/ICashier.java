package com.TestTransactions.cashier;

import java.util.List;

public interface ICashier {
	public void checkOut(String username, List<Integer> isbns);
}
