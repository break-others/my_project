package com.lanou.Dao;

import java.util.List;

import com.lanou.bean.User;

public interface IUserDao  {

	public List<User> getAll(int pagenum,int pagecount) throws Exception;
	
	public int getCount()throws Exception; 
	
	public void getAdd(String name,String pwd, String phone,String mail,String adress)throws Exception;
	
	public void getEdit(String id,String name,String pwd, String phone,String mail,String adress)throws Exception;
	
	public void getDelete(String id)throws Exception;
	
	public User getNameAndPwd(String username,String pwd)throws Exception;
}

