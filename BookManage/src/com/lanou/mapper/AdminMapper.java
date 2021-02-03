package com.lanou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.AdminUser;

public interface AdminMapper {

	public AdminUser getNameAndPwd(@Param("name")String adminname,@Param("pwd")String adminpwd)throws Exception;

	public List<AdminUser> getQuery(@Param("pagenum")int pagenum,@Param("pagecount")int pagecount) throws Exception;
	
	public Integer getCount() throws Exception;
	
	public void getAdd(@Param("name")String adminname,@Param("pwd")String pwd)throws Exception;
	
	public void getEdit(@Param("id")String id,@Param("name")String adminname,@Param("pwd")String pwd)throws Exception;
	
	public void getDelete(@Param("id")String id)throws Exception;
}
