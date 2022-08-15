package com.varxyz.test001.service;


import com.varxyz.test001.domain.Customer;

public interface CustomerService {
	Customer getCustomerByUserId(String userId);
	boolean isUser(String userId);
	void addCustomer(Customer customer);
	boolean isUserLogin(String userId, String passwd);
}
