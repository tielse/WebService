package com.chauthoiit.kali.dao;

import java.sql.ResultSet;

import java.sql.PreparedStatement;

public interface BaseDAO extends ShareConnectionManager {

	public boolean add(PreparedStatement pre);

	public boolean edit(PreparedStatement pre);

	public boolean del(PreparedStatement pre);
	
	public boolean excuteUpdateKali(PreparedStatement pre);

	public ResultSet get(PreparedStatement pre);

	public ResultSet get(String sql);
}
