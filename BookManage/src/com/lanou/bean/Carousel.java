package com.lanou.bean;

import java.io.Serializable;

public class Carousel implements Serializable {

	private Integer id;
	private String timg;
	public Carousel(Integer id, String timg) {
		super();
		this.id = id;
		this.timg = timg;
	}
	public Carousel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTimg() {
		return timg;
	}
	public void setTimg(String timg) {
		this.timg = timg;
	}
	
}
