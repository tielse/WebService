package com.chauthoiit.kali.service;

import java.util.List;

import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.model.Customer;

public interface AdminService extends BaseService {

	public boolean addAdmin(Admin admin);

	public boolean editAdmin(Admin admin);

	public boolean delAdmin(Admin admin);

	public boolean checkAdmin(Admin admin);

	public List<Admin> findAll();

	public Admin findById(int id);

	public List<Customer> findAll_Customer();

//	public Customer findById_Customer(int id);

	public Customer findByEmail_Customer(String str);
}
