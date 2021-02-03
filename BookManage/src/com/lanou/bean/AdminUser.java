package com.lanou.bean;

import java.io.Serializable;

public class AdminUser implements Serializable {

	private Integer id;
	private String adminname;
	private String adminpwd;
	
	public AdminUser(Integer id, String adminname, String adminpwd) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
	}
	public AdminUser() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	
	
}
