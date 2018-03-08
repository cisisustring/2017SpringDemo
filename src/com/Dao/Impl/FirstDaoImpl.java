package com.Dao.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.Dao.IFirstDao;

@Repository
public class FirstDaoImpl implements IFirstDao {
	@Override
	public void firstShow() {
		// TODO Auto-generated method stub
		System.out.println("[FirstDaoImpl]调用firstShow()****");
	}

	public FirstDaoImpl() {
		super();
		System.out.println("FirstDaoImpl()初始化*******");
	}

}
