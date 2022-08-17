package com.varxyz.test001.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.test001.service.CustomerServiceImpl;
import com.varxyz.test001.service.MenuServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	MenuServiceImpl menuService;
	
	@ GetMapping("/main")
	public String toMain(HttpSession session) {
		session.invalidate();
		return "main";
	}
}
