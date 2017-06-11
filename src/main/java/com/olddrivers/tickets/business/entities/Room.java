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
@Table(name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private Integer col;
	
	private Integer row;
	
	private Cinema cinema;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name = "room_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "room_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "room_col")
	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	@Column(name = "room_row")
	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cinema_id")
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}
