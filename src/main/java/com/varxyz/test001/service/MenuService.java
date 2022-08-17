package com.varxyz.test001.service;


import java.util.List;

import com.varxyz.test001.domain.Menu;

public interface MenuService {
	int addMenu(Menu menu);
	Menu isMenu(String menuName);
	List<Menu> getMenuItem();
}
