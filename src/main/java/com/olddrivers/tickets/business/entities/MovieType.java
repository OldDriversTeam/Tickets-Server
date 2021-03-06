package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "movieType")
public class MovieType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;

	private String name;
	
	 @Id
	 //@GeneratedValue(strategy = GenerationType.AUTO)
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	 @Column(name = "movie_type_id")
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Column(name = "movie_type_name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
