package com.olddrivers.tickets.util;

public enum FailedError {
	NO_ERROR(0),
	NAME_EXISTED(401),
	PHONE_EXISTED(402),
	EMAIL_EXISTED(403),
	USER_NOT_EXISTED(404),
	PASSWORD_ERROR(405);
	
	private Integer code;
	
	private FailedError(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
}