package com.varxyz.test001.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.test001.command.CustomerCommand;
import com.varxyz.test001.dao.CustomerDao;
import com.varxyz.test001.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	public boolean isUser(String userId) {
		return customerDao.isUser(userId);
	}
	
	
	public Customer getCustomerByUserId(String userId) {
		return customerDao.getCustomerByUserId(userId);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}


	@Override
	public boolean isUserLogin(String userId, String passwd) {
		return customerDao.isUserLogin(userId, passwd);
	}
	
}
