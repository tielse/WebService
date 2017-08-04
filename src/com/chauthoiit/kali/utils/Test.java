package com.chauthoiit.kali.utils;

import java.sql.SQLException;

import com.chauthoiit.kali.utils.ConnectionPool;
import com.chauthoiit.kali.utils.ConnectionPoolImpl;

public class Test {

	public static void main(String[] args) throws SQLException {
		ConnectionPool cp = new ConnectionPoolImpl();
		cp.getConnection();
		System.out.println("Ket noi that bai");
	}
}
