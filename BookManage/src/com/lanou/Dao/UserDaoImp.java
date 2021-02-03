package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class UserDaoImp implements IUserDao {

	@Override
	public List<User> getAll(int pagenum, int pagecount) throws Exception {
		String sql="select * from t_user limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet re=JDBCUtil.queryAll(sql);
		List<User> userlist=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String name=re.getString("name");
			String pwd=re.getString("pwd");
			String phone=re.getString("phone");
			String mail=re.getString("mail");
			String adress=re.getString("adress");
			User user=new User(id, name, pwd,phone, mail, adress);
			userlist.add(user);
			
		}
		return userlist;
	}

	@Override
	public int getCount() throws Exception {
		String sql="select count(*) count from t_user";
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			Integer count=re.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void getAdd(String name, String pwd, String phone, String mail, String adress) throws Exception {
		String sql="insert into t_user (name,pwd,phone,mail,adress) values ('"+name+"','"+pwd+"','"+phone+"','"+mail+"','"+adress+"')";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getEdit(String id, String name, String pwd, String phone, String mail, String adress) throws Exception {
		String sql="update t_user set name='"+name+"',pwd='"+pwd+"',phone='"+phone+"',mail='"+mail+"',adress='"+adress+"' where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getDelete(String id) throws Exception {
		String sql="delete from t_user where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
		
	}

	@Override
	public User getNameAndPwd(String username, String pwd) throws Exception {
		String sql="select * from t_user  where name=? and pwd=?";
		Object[] ob= {username,pwd};
		ResultSet re=JDBCUtil.queryUntil(sql, ob);
		if(re.next()) {
			Integer id=re.getInt("id");
			String phone=re.getString("phone");
			String mail=re.getString("mail");
			String adress=re.getString("adress");
			User user=new User(id, username, pwd, phone, mail, adress);
			return user;
		}
		return null;
	}

}
