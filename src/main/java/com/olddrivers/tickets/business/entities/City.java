package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	
	@Id
	@Column(name = "city_id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "city_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}