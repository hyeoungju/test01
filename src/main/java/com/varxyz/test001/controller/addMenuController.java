package com.varxyz.test001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.test001.command.MenuCommand;
import com.varxyz.test001.domain.Menu;
import com.varxyz.test001.service.MenuServiceImpl;

@Controller
public class addMenuController {
	
	@Autowired
	MenuServiceImpl menuService;
	
	@GetMapping("/menuItem/add_menu")
	public String addMenuForm(@ModelAttribute("menuCommand") MenuCommand menuCommand) {
		return "menuItem/add_menu";
	}
	
	@PostMapping("/menuItem/add_menu")
	public String addMenuForm(MenuCommand menuCommand, Model model) {
		String menuName = menuCommand.getMenuName();
		int menuPrice = menuCommand.getMenuPrice();
		String menuType = menuCommand.getMenuType();
		
		
		Menu result = menuService.isMenu(menuName);
		if (result != null ) {
			model.addAttribute("msg", "메뉴가 존재합니다.");
			model.addAttribute("url", "/test001/menuItem/add_menu");
			return "alert";
		}

		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		menu.setMenuType(menuType);

		menuService.addMenu(menu);
		model.addAttribute("menuCommand", menuCommand);
		return "menuItem/add_menu";
	}
	
}
