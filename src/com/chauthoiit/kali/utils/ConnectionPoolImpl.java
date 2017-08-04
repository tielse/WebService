package com.chauthoiit.kali.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ConnectionPoolImpl implements ConnectionPool {

	private Connection connection = null;
	// Thong tin account truy cap db
	private String user = "root";
	private String pass = "toor";
	// Thong tin trinh dieu khien
	private String driver = "com.mysql.jdbc.Driver";
	// Thong tin duong dan toi CSDL trong MYSQL
	private String url = "jdbc:mysql://localhost:3306/Project";

	public ConnectionPoolImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("Connection susscess!");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closed(Statement st, ResultSet rs, Connection conn) {
		// TODO Auto-generated method stub
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
