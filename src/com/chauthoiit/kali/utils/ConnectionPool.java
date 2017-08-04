package com.chauthoiit.kali.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public interface ConnectionPool {

	// tra ve connection
	public Connection getConnection() throws SQLException;

	// dong ket noi
	public void closed(Statement st, ResultSet rs, Connection conn);
}
