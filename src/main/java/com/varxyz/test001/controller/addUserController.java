package com.varxyz.test001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.test001.command.CustomerCommand;
import com.varxyz.test001.domain.Customer;
import com.varxyz.test001.service.CustomerServiceImpl;

@Controller
public class addUserController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("/join/add_customer")
	public String addCustomerForm(@ModelAttribute("customerCommand") CustomerCommand customerCommand) {
		return "join/add_customer";
	}
	
	@PostMapping("/join/add_customer")
	public String addCustomerForm(CustomerCommand customerCommand, Model model) {
		String userId = customerCommand.getUserId();
		String passwd = customerCommand.getPasswd();
		String name = customerCommand.getName();
		
		boolean result = customerService.isUser(userId);
		if (result == true ) {
			model.addAttribute("msg", "아이디가 존재합니다.");
			model.addAttribute("url", "/test001/join/add_customer");
			return "alert";
		}
		
		Customer customer = new Customer();
		customer.setUserId(userId);
		customer.setPasswd(passwd);
		customer.setName(name);
		
		customerService.addCustomer(customer);
		model.addAttribute("customerCommand", customerCommand);
		return "main";
	}
	
}
