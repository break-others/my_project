package com.lanou.bean;

import java.io.Serializable;

public class User implements Serializable {

	private Integer id;
	private String name;
	private String pwd;
	private String phone;
	private String mail;
	private String adress;
	private String backup1;
	private String backup2;
	private String backup3;
	
	
	public String getPhone() {
		return phone;
	}

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(Integer id, String name, String pwd, String phone, String mail, String adress) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.mail = mail;
		this.adress = adress;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBackup1() {
		return backup1;
	}
	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}
	public String getBackup2() {
		return backup2;
	}
	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}
	public String getBackup3() {
		return backup3;
	}
	public void setBackup3(String backup3) {
		this.backup3 = backup3;
	}
	
}
