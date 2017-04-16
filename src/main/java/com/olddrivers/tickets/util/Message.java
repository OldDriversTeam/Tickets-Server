package com.olddrivers.tickets.util;

import java.io.Serializable;

import com.olddrivers.tickets.business.entities.User;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer statusCode;
	//private List<Map<String, Integer>> errorCodeList = new ArrayList<Map<String, Integer>>();
	private Integer errorCode;
	private User user;
	
	public Message(Status status, FailedError failedError, User user) {
		this.setStatusCode(status.getCode());
		this.errorCode = failedError.getCode();
		this.user = user;
	}

	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{")
		.append("\"status\":").append(statusCode).append(",")
		.append("\"errorCode\":").append(errorCode).append(",")
		.append("\"user\":").append(user!=null?user.toString():"{}")
		.append("}");
		return builder.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
