package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.AdminUser;
import com.lanou.util.JDBCUtil;

public class AdminUserDaoImp implements IAdminUserDao {

	@Override
	public AdminUser getNameAndPwd(String adminname, String adminpwd) throws Exception {
		String sql="select * from t_admin where adminname=? and adminpwd=?";
		Object[] ob= {adminname,adminpwd};
		ResultSet re=JDBCUtil.queryUntil(sql, ob);
		if(re.next()) {
			Integer id=re.getInt("id");
			AdminUser admin=new AdminUser(id, adminname, adminpwd);
			return admin;
		}
		return null;
	}

	@Override
	public List<AdminUser> getQuery(int pagenum,int pagecount) throws Exception {
		String sql="select * from t_admin limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet re=JDBCUtil.queryAll(sql);
		List<AdminUser> adminlist=new ArrayList<>();
		while(re.next()) {
			int id=re.getInt("id");
			String adminname=re.getString("adminname");
			String adminpwd=re.getString("adminpwd");
			AdminUser admin=new AdminUser(id, adminname, adminpwd);
			adminlist.add(admin);
		}
		return adminlist;
	}
	
	public int getCount() throws Exception {
		String sql="select count(id) count from t_admin";
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			int count=re.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void getAdd(String adminname, String pwd) throws Exception {
		String sql="insert into t_admin (adminname,adminpwd) values ('"+adminname+"','"+pwd+"')";
		JDBCUtil.zhengShanGai(sql);
		
	}

	@Override
	public void getEdit(String id,String adminname, String pwd) throws Exception {
		String sql="update t_admin set adminname='"+adminname+"',adminpwd='"+pwd+"' where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getDelete(String id) throws Exception {
		String sql="delete from t_admin where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
	}

}
