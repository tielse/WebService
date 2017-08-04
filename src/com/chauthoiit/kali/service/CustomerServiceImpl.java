package com.chauthoiit.kali.service;

import com.chauthoiit.kali.controller.CustomerTranfer;
import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.utils.ConnectionPool;

public class CustomerServiceImpl implements CustomerService {

	private CustomerTranfer customerTranfer;

	@Override
	public ConnectionPool getConnectionPool() {
		// TODO Auto-generated method stub
		return customerTranfer.getConnectionPool();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerTranfer.addCustomer(customer);
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerTranfer.checkCustomer(customer);
	}

}
