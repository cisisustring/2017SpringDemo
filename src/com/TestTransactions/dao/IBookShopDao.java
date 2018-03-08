package com.TestTransactions.dao;

public interface IBookShopDao {
	public int findBookPriceByIsbn(int isbn);

	public void updateBookstockByIsbn(int isbn);

	public void updateUserBalance(String username, int price);
}
