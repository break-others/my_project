package com.lanou.Dao;

import java.util.List;

import com.lanou.bean.Product;
import com.lanou.bean.Type;

public interface IProductDao {

	public List<Product> getAll(int pagenum,int pagecount) throws Exception;
	
	public int getCount()throws Exception;
	
	public void getDelete(String id)throws Exception;
	
	public void getAdd(String pname,String pimg,Double price,String title,String pv,String typid)throws Exception;
	
	public void getEdit( String id,String pname,String pimg,String price,String ptitle,String pv,String typeid)throws Exception;

	public List<Product> getPro(String typeid)throws Exception;
	
	public List<Product> getPro()throws Exception;
	
	public List<Product> getProList(String pname)throws Exception;
	
	public List<Product> getByID(int id)throws Exception;
	
	public int getTypeID(String id)throws Exception;
}
