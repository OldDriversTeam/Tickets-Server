package com.olddrivers.tickets.util;

public enum Status {
	
	SUCCEED(200), FAILED(400);
	
	private Integer code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public static Status parse(Integer code) {
        if (code == null) {
            throw new IllegalArgumentException("code cannot be null for Status");
        }
        if (code== 200) {
            return SUCCEED;
        } else if (code==400) {
            return FAILED;
        }
        throw new IllegalArgumentException("Code \"" + code + "\" does not correspond to any Status");
	}
	
	public Integer getCode() {
		return this.code;
	}
	
}