package com.niit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	public CustomerDao customerDao;
	
	@Autowired
	public void registerCustomer(Customer customer) {
		customerDao.registerCustomer(customer);
	}
	
}
