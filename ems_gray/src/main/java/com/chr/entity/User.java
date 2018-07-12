package com.chr.entity;

import java.io.Serializable;

public class User implements Serializable{

	private String id;
	private String username;
	private String realname;
	private String password;
	private String sex;
	private String salt;

	public User() {
	}

	public User(String id, String username, String realname, String password, String sex, String salt) {
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
		this.salt = salt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", realname='" + realname + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", salt='" + salt + '\'' +
				'}';
	}
}
