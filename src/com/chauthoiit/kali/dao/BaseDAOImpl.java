package com.chauthoiit.kali.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.chauthoiit.kali.utils.ConnectionPool;

import com.chauthoiit.kali.utils.ConnectionPoolImpl;

public class BaseDAOImpl implements BaseDAO {

	private ConnectionPool connectionPool;

	protected Connection connection;

	public BaseDAOImpl(ConnectionPool cp) {
		// TODO Auto-generated constructor stub
		if (cp == null)
			connectionPool = new ConnectionPoolImpl();
		else
			connectionPool = cp;
		try {
			connection = connectionPool.getConnection();
			if (connection.getAutoCommit())
				connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public ConnectionPool getConnectionPool() {
		// TODO Auto-generated method stub
		return connectionPool;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return excuteUpdateKali(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return excuteUpdateKali(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return excuteUpdateKali(pre);
	}

	@Override
	public ResultSet get(PreparedStatement pre) {
		// TODO Auto-generated method stub
		try {
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet get(String sql) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			return get(pre);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean excuteUpdateKali(PreparedStatement pre) {
		// TODO Auto-generated method stub
		if (pre != null) {
			try {
				int numR = pre.executeUpdate();
				if (numR == 0)
					connection.rollback();
				else {
					connection.commit();
					return true;
				}
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}

}
