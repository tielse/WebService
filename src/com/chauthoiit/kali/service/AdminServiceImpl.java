package com.chauthoiit.kali.service;

import java.util.List;

import com.chauthoiit.kali.controller.AdminTranfer;
import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.utils.ConnectionPool;

public class AdminServiceImpl implements AdminService {

	private AdminTranfer adminTranfer;

	@Override
	public ConnectionPool getConnectionPool() {
		// TODO Auto-generated method stub
		return adminTranfer.getConnectionPool();
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminTranfer.addAdmin(admin);
	}

	@Override
	public boolean editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminTranfer.editAdmin(admin);
	}

	@Override
	public boolean delAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminTranfer.delAdmin(admin);
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminTranfer.checkAdmin(admin);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminTranfer.findAll();
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return adminTranfer.findById(id);
	}

	@Override
	public List<Customer> findAll_Customer() {
		// TODO Auto-generated method stub
		return adminTranfer.findAll_Customer();
	}

	// @Override
	// public Customer findById_Customer(int id) {
	// // TODO Auto-generated method stub
	// return adminTranfer.findById_Customer(id);
	// }

	@Override
	public Customer findByEmail_Customer(String str) {
		// TODO Auto-generated method stub
		return adminTranfer.findByEmail_Customer(str);
	}

}
