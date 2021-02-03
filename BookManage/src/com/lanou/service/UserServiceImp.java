package com.lanou.service;

import java.util.List;

import com.lanou.Dao.IUserDao;
import com.lanou.Dao.UserDaoImp;
import com.lanou.bean.User;

public class UserServiceImp implements IUserService  {

	private IUserDao userDao=new UserDaoImp();
	@Override
	public List<User> getAll(int pagenum, int pagecount) throws Exception {
		
		return userDao.getAll(pagenum, pagecount);
	}
	@Override
	public int getCount() throws Exception {
		userDao.getCount();
		return userDao.getCount();
	}
	@Override
	public void getAdd(String name, String pwd, String phone, String mail, String adress) throws Exception {
		userDao.getAdd(name, pwd, phone, mail, adress);
	}
	@Override
	public void getEdit(String id,String name,String pwd, String phone,String mail,String adress)throws Exception{
		userDao.getEdit(id, name, pwd, phone, mail, adress);
	}
	@Override
	public void getDelete(String id) throws Exception {
		
		userDao.getDelete(id);
	}
	@Override
	public User getNameAndPwd(String username, String pwd) throws Exception {
		
		return userDao.getNameAndPwd(username, pwd);
	}
	
	
}
