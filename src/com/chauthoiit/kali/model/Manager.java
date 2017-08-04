package com.chauthoiit.kali.model;

import java.io.Serializable;

public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer customer_id;
	private Integer admin_id;
	private Integer manager_id;
	private int manager_registry;

	public Manager(Integer c_id, Integer a_id, Integer m_id, int m_registry) {
		// TODO Auto-generated constructor stub
		customer_id = c_id;
		admin_id = a_id;
		manager_id = m_id;
		manager_registry = m_registry;
	}

	public Manager() {
		super();
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_registry(int manager_registry) {
		this.manager_registry = manager_registry;
	}

	public int getManager_registry() {
		return manager_registry;
	}
}
