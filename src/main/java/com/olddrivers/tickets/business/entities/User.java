package com.olddrivers.tickets.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.olddrivers.tickets.util.RegistForm;

import javax.persistence.Id;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;

	private String password;
	
	private String gender;
	
	private Integer age;
	
	private String phone;
	
	private String email;
	
	private String avatar;
	
	public User() {
		super();
		
	}
	
	public User(RegistForm registForm) {
		super();
		
		this.name = registForm.getName();
		this.password = registForm.getPassword();
		this.phone = registForm.getPhone();
		
	}
	
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id")
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "user_name")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	@Column(name = "user_password")
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "user_gender")
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "user_age")
	public Integer getAge() {
		return this.age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name = "user_phone", unique = true)
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "user_email")
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "user_avatar")
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
//	@Override
//    public String toString() {
//        final StringBuilder builder = new StringBuilder();
//        builder.append("{")
//        .append("\"id\":").append(id).append(",")
//        .append("\"name\":\"").append(name).append("\",")
//        .append("\"password\":\"").append(password).append("\",")
//        .append("\"gender\":\"").append(gender).append("\",")
//        .append("\"age\":").append(age).append(",")
//        .append("\"phone\":\"").append(phone).append("\",")
//        .append("\"email\":\"").append(email).append("\"")
//        .append("}");
//        return builder.toString();
//    }


	
}
