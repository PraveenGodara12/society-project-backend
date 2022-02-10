package com.SocietyProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="houseNo")
	private int houseNo;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="flatSize")
	private String flatSize;
	
	public User() {
	}
	public User(int userID, String name, String username, String password, int houseNo, String email, String phone,
			String flatSize) {
		super();
		this.userID = userID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.houseNo = houseNo;
		this.email = email;
		this.phone = phone;
		this.flatSize = flatSize;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFlatSize() {
		return flatSize;
	}
	public void setFlatSize(String flatSize) {
		this.flatSize = flatSize;
	}
}
