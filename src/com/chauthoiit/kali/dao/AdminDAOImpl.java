package com.chauthoiit.kali.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.chauthoiit.kali.model.Admin;
import com.chauthoiit.kali.utils.ConnectionPool;

public class AdminDAOImpl extends BaseDAOImpl implements AdminDAO {

	public AdminDAOImpl(ConnectionPool cp) {
		super(cp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into admin(" + " a_id, a_name, a_user, a_pass, a_permission " + ")"
					+ " values( ?, ?, ?, ?)";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, admin.getAdmin_id());
			pre.setString(2, admin.getAdmin_name());
			pre.setString(3, admin.getAdmin_user());
			pre.setString(4, admin.getAdmin_password());
			// pre.setInt(5, admin.getAdmin_permission());
			return add(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String sql = "update admin set" + " a_id = ?, a_name = ?, a_user = ?, a_pass = ?" + " where a_id = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, admin.getAdmin_id());
			pre.setString(2, admin.getAdmin_name());
			pre.setString(3, admin.getAdmin_user());
			pre.setString(4, admin.getAdmin_password());
			// pre.setInt(5, admin.getAdmin_permission());
			return edit(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean delAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from admin where a_id = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, admin.getAdmin_id());
			return del(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from admin where a_user = ? and a_pass = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, admin.getAdmin_user());
			pre.setString(2, admin.getAdmin_password());
			ResultSet rs = pre.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public ResultSet findAdll() {
		// TODO Auto-generated method stub
		String sql = "select * from admin";
		return get(sql);
	}

	@Override
	public ResultSet findById(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from admin where a_id = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			return get(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	@Override
	public ResultSet findAll_Customer() {
		// TODO Auto-generated method stub
		String sql = "select * from customer";
		return get(sql);
	}

	// @Override
	// public ResultSet findById_Customer(int id) {
	// // TODO Auto-generated method stub
	// try {
	// String sql = "select * from customer where c_id = ?";
	// PreparedStatement pre = connection.prepareStatement(sql);
	// pre.setInt(1, id);
	// return get(pre);
	// } catch (SQLException e) {
	// // TODO: handle exception
	// Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
	// }
	// return null;
	// }

	@Override
	public ResultSet findByEmail_Customer(String str) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from customer where c_email = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, str);
			return get(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	@Override
	public Admin getAdmin(String user) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		try {
			String sql = "select * from admin where a_user ='" + user + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				admin.setAdmin_id(rs.getInt(1));
				admin.setAdmin_name(rs.getString(2));
				admin.setAdmin_user(rs.getString(3));
				admin.setAdmin_password(rs.getString(4));
				// admin.setAdmin_permission(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return admin;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from admin where a_user = '" + username + "' and a_pass = '" + password + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean checkLogin(String pass) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from admin where a_pass= '" + pass + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public Admin findAdmin(String user, String pass) {
		// TODO Auto-generated method stub
		try {
			Admin admin = new Admin();
			String sql = "select * from admin where a_user = ? and a_pass = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				admin.setAdmin_user(user);
				admin.setAdmin_password(pass);
				return admin;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}
