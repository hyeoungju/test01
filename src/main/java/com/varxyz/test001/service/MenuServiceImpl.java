package com.varxyz.test001.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.test001.dao.MenuDao;
import com.varxyz.test001.domain.Menu;


public class MenuServiceImpl implements MenuService{
	
	@Autowired
	MenuDao menuDao;

	@Override
	public int addMenu(Menu menu) {
		return menuDao.addMenu(menu);
	}

	@Override
	public Menu isMenu(String menuName) {
		return menuDao.isMenu(menuName);
	}



	
}
