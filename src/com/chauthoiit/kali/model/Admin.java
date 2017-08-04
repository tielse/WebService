package com.chauthoiit.kali.model;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer admin_id;
	private String admin_name;
	private String admin_user;
	private String admin_password;
//	private Integer admin_permission;

	public Admin(Integer a_id, String a_name, String a_user, String a_password) {
		// TODO Auto-generated constructor stub
		admin_id = a_id;
		admin_name = a_name;
		admin_user = a_user;
		admin_password = a_password;
//		admin_permission = a_permission;
	}

	public Admin() {
		super();
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_user(String admin_user) {
		this.admin_user = admin_user;
	}

	public String getAdmin_user() {
		return admin_user;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	// public void setAdmin_permission(Integer admin_permission) {
	// this.admin_permission = admin_permission;
	// }
	//
	// public Integer getAdmin_permission() {
	// return admin_permission;
	// }
}
