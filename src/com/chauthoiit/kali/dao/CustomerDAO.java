package com.chauthoiit.kali.dao;

import com.chauthoiit.kali.model.Customer;

public interface CustomerDAO extends BaseDAO {

	public boolean addCustomer(Customer customer);

	public boolean checkInfo(Customer customer);
}
