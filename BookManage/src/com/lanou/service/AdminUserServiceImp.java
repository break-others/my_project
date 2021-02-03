package com.lanou.service;

import java.util.List;

import com.lanou.Dao.AdminUserDaoImp;
import com.lanou.Dao.IAdminUserDao;
import com.lanou.bean.AdminUser;
import com.lanou.mapper.AdminMapper;
import com.lanou.util.SqlSessionUity;

public class AdminUserServiceImp implements IAdminUserService {

	private AdminMapper mapper=(AdminMapper) SqlSessionUity.getSqlSession(AdminMapper.class);
	
//	private IAdminUserDao adminDao=new AdminUserDaoImp();
	
	@Override
	public AdminUser getNameAndPwd(String adminname, String adminpwd) throws Exception {
		return mapper.getNameAndPwd(adminname, adminpwd);
	}
	
	@Override
	public List<AdminUser> getQuery(int pagenum,int pagecount) throws Exception {
		return mapper.getQuery(pagenum, pagecount);
	}
	
	@Override
	public Integer getCount() throws Exception {
		return mapper.getCount();
	}
	
	@Override
	public void getAdd(String adminname, String pwd) throws Exception {
		mapper.getAdd(adminname, pwd);
	}
	
	@Override
	public void getEdit(String id,String adminname, String pwd) throws Exception {
		mapper.getEdit(id, adminname, pwd);
		
	}
	
	@Override
	public void getDelete(String id) throws Exception {
		mapper.getDelete(id);
		
	}
//	@Override
//	public AdminUser getNameAndPwd(String adminname, String adminpwd) throws Exception {
//		return adminDao.getNameAndPwd(adminname, adminpwd);
//	}
//	@Override
//	public List<AdminUser> getQuery(int pagenum,int pagecount) throws Exception {
//		
//		return adminDao.getQuery(pagenum,pagecount);
//	}
//	@Override
//	public int getCount() throws Exception {
//		
//		return adminDao.getCount();
//	}
//	@Override
//	public void getAdd(String adminname, String pwd) throws Exception {
//		adminDao.getAdd(adminname, pwd);
//	}
//	@Override
//	public void getEdit(String id,String adminname, String pwd) throws Exception {
//		adminDao.getEdit(id,adminname, pwd);
//		
//	}
//	@Override
//	public void getDelete(String id) throws Exception {
//		adminDao.getDelete(id);
//		
//	}

	
}
