package com.chauthoiit.kali.service;

import com.chauthoiit.kali.model.Customer;

public interface CustomerService extends BaseService {

	public boolean addCustomer(Customer customer);

	public boolean checkCustomer(Customer customer);
}
