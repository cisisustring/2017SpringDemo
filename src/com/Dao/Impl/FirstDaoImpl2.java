package com.Dao.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.Dao.IFirstDao;

@Repository("firstDaoImpl2")
public class FirstDaoImpl2 implements IFirstDao {
	@Override
	public void firstShow() {
		// TODO Auto-generated method stub
		System.out.println("[FirstDaoImpl2]调用firstShow()****");
	}

	public FirstDaoImpl2() {
		super();
		System.out.println("FirstDaoImpl2()初始化*******");
	}

}
