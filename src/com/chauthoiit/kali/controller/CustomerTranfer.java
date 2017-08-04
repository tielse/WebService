package com.chauthoiit.kali.controller;

import com.chauthoiit.kali.dao.CustomerDAO;
import com.chauthoiit.kali.dao.CustomerDAOImpl;
import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.service.CustomerService;
import com.chauthoiit.kali.utils.ConnectionPool;

public class CustomerTranfer implements CustomerService {

	private CustomerDAO customerDAO;

	public CustomerTranfer(ConnectionPool cp) {
		// TODO Auto-generated constructor stub
		customerDAO = new CustomerDAOImpl(cp);
	}

	@Override
	public ConnectionPool getConnectionPool() {
		// TODO Auto-generated method stub
		return customerDAO.getConnectionPool();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.checkInfo(customer);
	}

}
