package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeService {

	public List<Type> getAll() throws Exception;
	
	public void getAdd(String title,int parentid)throws Exception;
	
	public void getEdit(int id,String title)throws Exception;
	
	public void getDelete(int id)throws Exception;
	
    public List<Type> getOneList( )throws Exception;
	
	public List<Type> getTwoList(String parentid )throws Exception;
	
	public List<Type> getThreeList(String parentid )throws Exception;
	
	public int getTypeid(String title)throws Exception;
	
}
