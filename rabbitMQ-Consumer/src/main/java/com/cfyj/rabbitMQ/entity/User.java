package com.cfyj.rabbitMQ.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String password;
	private String description;

	public void setId(Integer id) {
		this.id = id;
	}
	private void geti() {
		// TODO Auto-generated method stub

	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName, String password, String description) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.description = description;
	}

}
