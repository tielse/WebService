package com.chauthoiit.kali.model;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private Integer customer_id;
	private String customer_name;
	private String customer_email;
	private String customer_message;
	private String customer_subject;

	public Customer( String name, String email, String subject, String message) {
		// TODO Auto-generated constructor stub
//		customer_id = id;
		customer_name = name;
		customer_email = email;
		customer_message = message;
		customer_subject = subject;
	}

	public Customer() {
		super();
	}

	// public void setCustomer_id(int customer_id) {
	// this.customer_id = customer_id;
	// }
	//
	// public int getCustomer_id() {
	// return customer_id;
	// }

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_message(String customer_message) {
		this.customer_message = customer_message;
	}

	public String getCustomer_message() {
		return customer_message;
	}

	public void setCustomer_subject(String customer_subject) {
		this.customer_subject = customer_subject;
	}

	public String getCustomer_subject() {
		return customer_subject;
	}

}
