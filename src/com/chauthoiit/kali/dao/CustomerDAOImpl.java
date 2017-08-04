package com.chauthoiit.kali.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chauthoiit.kali.model.Customer;
import com.chauthoiit.kali.utils.ConnectionPool;

public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO {

	public CustomerDAOImpl(ConnectionPool cp) {
		super(cp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into customer values( ?, ?, ?, ?)";
			PreparedStatement pre = connection.prepareStatement(sql);
			// pre.setInt(1, customer.getCustomer_id());
			pre.setString(1, customer.getCustomer_name());
			pre.setString(2, customer.getCustomer_email());
			pre.setString(3, customer.getCustomer_subject());
			pre.setString(4, customer.getCustomer_message());
			return add(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean checkInfo(Customer customer) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from customer where c_name = ? and c_email = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			// pre.setInt(1, customer.getCustomer_id());
			pre.setString(1, customer.getCustomer_name());
			pre.setString(2, customer.getCustomer_email());
			pre.setString(3, customer.getCustomer_subject());
			pre.setString(4, customer.getCustomer_message());
			ResultSet rs = pre.executeQuery();
			while (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
