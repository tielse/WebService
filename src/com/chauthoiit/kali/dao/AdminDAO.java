package com.chauthoiit.kali.dao;

import java.sql.ResultSet;

import com.chauthoiit.kali.model.Admin;

public interface AdminDAO extends BaseDAO {

	public boolean addAdmin(Admin admin);

	public boolean editAdmin(Admin admin);

	public boolean delAdmin(Admin admin);

	public boolean checkAdmin(Admin admin);

	public ResultSet findAdll();

	public ResultSet findById(int id);

	public ResultSet findAll_Customer();

	// public ResultSet findById_Customer(int id);

	public ResultSet findByEmail_Customer(String str);

	public Admin getAdmin(String id);

	public boolean login(String username, String password);

	public boolean checkLogin(String pass);

	public Admin findAdmin(String user, String pass);
}
