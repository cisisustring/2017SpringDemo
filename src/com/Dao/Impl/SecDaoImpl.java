package com.Dao.Impl;

import org.springframework.stereotype.Repository;

import com.Dao.ISecDao;
@Repository
public class SecDaoImpl implements ISecDao {

	@Override
	public void secondShow() {
		// TODO Auto-generated method stub
		System.out.println("[SecDaoImpl]����secondShow()*****");

	}

	public SecDaoImpl() {
		super();
		System.out.println("SecDaoImpl()��ʼ��********");
	}

}
