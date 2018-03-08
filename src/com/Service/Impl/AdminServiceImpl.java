package com.Service.Impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Dao.*;
import com.Service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	@Resource(name="firstDaoImpl2")
	/*@Qualifier("firstDaoImpl2")*/
	private IFirstDao firstDaoImpl;
	@Resource
	private ISecDao iSecDao;

	@Override
	public void showDao() {
		// TODO Auto-generated method stub
		this.firstDaoImpl.firstShow();
		this.iSecDao.secondShow();
		System.out.println("[AdminServiceImpl]��showDao()����----");
	}

	public AdminServiceImpl() {
		super();
		System.out.println("AdminServiceImpl**");
	}

}
