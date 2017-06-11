package com.olddrivers.tickets.util;


public class OrderForm {
	private String showingId;
	private String userId;
	private Integer count;
	private Integer[][] seats;
	public String getShowingId() {
		return showingId;
	}
	public void setShowingId(String showingId) {
		this.showingId = showingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer[][] getSeats() {
		return seats;
	}
	public void setSeats(Integer[][] seats) {
		this.seats = seats;
	}
}
