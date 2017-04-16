package com.olddrivers.tickets.util;

public class RegistForm {
	
	private String name;
	private String phone;
	private String password;
	
	public RegistForm() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "registForm: " +
					this.name+" , "+this.password + " , " + this.phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
