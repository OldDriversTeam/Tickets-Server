package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cinema")
public class Cinema implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private City city;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name = "cinema_id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "cinema_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "cinema_address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "cinema_phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="city_id")
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}