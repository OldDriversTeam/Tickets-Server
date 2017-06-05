package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Integer seatColNum;
	
	private Integer seatRowNum;
	
	private Boolean isSold;
	
	private Showing showing;
	
	private User user;
	

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name = "ticket_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="ticket_seatColNum")
	public Integer getSeatColNum() {
		return seatColNum;
	}
	
	public void setSeatColNum(Integer seatColNum) {
		this.seatColNum = seatColNum;
	}
	
	@Column(name="ticket_seatRowNum")
	public Integer getSeatRowNum() {
		return seatRowNum;
	}
	
	public void setSeatRowNum(Integer seatRowNum) {
		this.seatRowNum = seatRowNum;
	}

	@Column(name="ticket_isSold")
	public Boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "showing_id")
	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
