package com.lanou.service;

import java.util.List;

import com.lanou.bean.AdminUser;

public interface IAdminUserService {

	public AdminUser getNameAndPwd(String adminname,String adminpwd)throws Exception;
	
	public List<AdminUser> getQuery(int pagenum,int pagecount) throws Exception;
	
	public Integer getCount() throws Exception;
	
	public void getAdd(String adminname,String pwd)throws Exception;
	
	public void getEdit(String id,String adminname,String pwd)throws Exception;
	
	public void getDelete(String id)throws Exception;
}
