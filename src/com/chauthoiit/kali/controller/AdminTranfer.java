package com.chauthoiit.kali.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.chauthoiit.kali.utils.ConnectionPool;

import com.chauthoiit.kali.dao.AdminDAO;
import com.chauthoiit.kali.dao.AdminDAOImpl;
import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.service.AdminService;

public class AdminTranfer implements AdminService {

	private AdminDAO adminDAO;

	public AdminTranfer(ConnectionPool cp) {
		// TODO Auto-generated constructor stub
		adminDAO = new AdminDAOImpl(cp);
	}

	@Override
	public ConnectionPool getConnectionPool() {
		// TODO Auto-generated method stub
		return adminDAO.getConnectionPool();
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.addAdmin(admin);
	}

	@Override
	public boolean editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.editAdmin(admin);
	}

	@Override
	public boolean delAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.delAdmin(admin);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		List<Admin> lst = null;
		ResultSet rs = adminDAO.findAdll();
		if (rs != null) {
			lst = new ArrayList<Admin>();
			Admin admin = null;
			try {
				while (rs.next()) {
					admin = new Admin();
					admin.setAdmin_id(rs.getInt(1));
					admin.setAdmin_name(rs.getString(2));
					admin.setAdmin_user(rs.getString(3));
					admin.setAdmin_password(rs.getString(4));
					// admin.setAdmin_permission(rs.getInt(5));
					lst.add(admin);
				}
			} catch (SQLException e) {
				// TODO: handle exception

				Logger.getLogger(AdminTranfer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return lst;
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		Admin admin = null;
		ResultSet rs = adminDAO.findById(id);
		try {
			if (rs != null && rs.next()) {
				admin = new Admin();
				admin.setAdmin_id(rs.getInt(1));
				admin.setAdmin_name(rs.getString(2));
				admin.setAdmin_user(rs.getString(3));
				admin.setAdmin_password(rs.getString(4));
				// admin.setAdmin_permission(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminTranfer.class.getName()).log(Level.SEVERE, null, e);
		}
		return admin;
	}

	@Override
	public List<Customer> findAll_Customer() {
		// TODO Auto-generated method stub
		List<Customer> lst = null;
		ResultSet rs = adminDAO.findAll_Customer();
		if (rs != null) {
			lst = new ArrayList<Customer>();
			Customer customer = null;
			try {
				while (rs.next()) {
					customer = new Customer();
					// customer.setCustomer_id(rs.getInt(1));
					customer.setCustomer_name(rs.getString(1));
					customer.setCustomer_email(rs.getString(2));
					customer.setCustomer_subject(rs.getString(3));
					customer.setCustomer_message(rs.getString(4));
					lst.add(customer);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				Logger.getLogger(AdminTranfer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return lst;
	}

	// @Override
	// public Customer findById_Customer(int id) {
	// // TODO Auto-generated method stub
	// Customer customer = null;
	// ResultSet rs = adminDAO.findById_Customer(id);
	// try {
	// if (rs != null && rs.next()) {
	// customer = new Customer();
	// customer.setCustomer_id(rs.getInt(1));
	// customer.setCustomer_name(rs.getString(2));
	// customer.setCustomer_email(rs.getString(3));
	// customer.setCustomer_subject(rs.getString(4));
	// customer.setCustomer_message(rs.getString(5));
	// }
	// } catch (SQLException e) {
	// // TODO: handle exception
	// Logger.getLogger(AdminTranfer.class.getName()).log(Level.SEVERE, null, e);
	// }
	// return customer;
	// }

	@Override
	public Customer findByEmail_Customer(String str) {
		// TODO Auto-generated method stub
		Customer customer = null;
		ResultSet rs = adminDAO.findByEmail_Customer(str);
		try {
			if (rs != null && rs.next()) {
				customer = new Customer();
				// customer.setCustomer_id(rs.getInt(1));
				customer.setCustomer_name(rs.getString(1));
				customer.setCustomer_email(rs.getString(2));
				customer.setCustomer_subject(rs.getString(3));
				customer.setCustomer_message(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminTranfer.class.getName()).log(Level.SEVERE, null, e);
		}
		return customer;
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.checkAdmin(admin);
	}

}
