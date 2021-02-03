package com.lanou.service;

import java.util.List;

import com.lanou.bean.Carousel;

public interface ICarouselService {

	public List<Carousel> getQuery() throws Exception;
	
	public List<Carousel> getQuery(int pagenum,int pagecount) throws Exception;
	
	public void getDelete(String id)throws Exception;
	
	public void getAdd(String timg) throws Exception;
	
	public int getCount()throws Exception;
}
