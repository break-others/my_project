package com.lanou.service;

import java.util.List;

import com.lanou.bean.Chart;

public interface IChartService {

	
	public List<Chart> getAll(int pagenum,int pagecount) throws Exception;
	
	public int getCount()throws Exception;
	
	public void getDelete(String id)throws Exception;
	
	public List<Chart> getAll(String userid) throws Exception;
	
	public void getAdd(String userid,String productid)throws Exception;
}
