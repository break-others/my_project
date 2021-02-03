package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class TypeDaoImp implements ITypeDao {

	@Override
	public List<Type> getQuery(int parentid) throws Exception {
		String sql="select * from pro_type where parentid=? ";
		Object[] ob= {parentid};
		ResultSet re=JDBCUtil.queryUntil(sql, ob);
		List<Type> typelist=new ArrayList<>();
		while(re.next()) {		
			Integer id=re.getInt("id");
			String title=re.getString("typename");
			Type type=new Type(id, title, parentid, null);
			typelist.add(type);
		}
		return typelist;
	}

	@Override
	public void getAdd(String title, int parentid) throws Exception {
		String sql="insert into pro_type (typename,parentid)values('"+title+"',"+parentid+")";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getEdit(int id, String title) throws Exception {
		String sql = "update pro_type set typename='"+title+"' where id="+id+"";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getDelete(int id) throws Exception {
		String sql="delete  from pro_type where id="+id+"";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public Type getType(int typeid) throws Exception {
		String sql="select * from pro_type where id="+typeid+"";
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			Integer id=re.getInt("id");
			String title=re.getString("typename");
			Integer parentid=re.getInt("parentid");
			Type type=new Type(id, title, parentid);
			return type;
		}
		return null;
	}

	@Override
	public List<Type> getOneList() throws Exception {
		String sql="select * from pro_type where parentid="+0+"";
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Type> typelist1=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String title=re.getString("typename");
			Integer parentid=re.getInt("parentid");
			Type type=new Type(id, title, parentid);
			typelist1.add(type);
		}
		return typelist1;
	}

	@Override
	public List<Type> getTwoList(String parentid) throws Exception {
		String sql="select * from pro_type where parentid='"+parentid+"'";
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Type> typelist2=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String title=re.getString("typename");
			int parent=re.getInt("parentid");
			Type type=new Type(id, title, parent);
			typelist2.add(type);
		}
		return typelist2;
	}

	@Override
	public List<Type> getThreeList(String parentid) throws Exception {
		String sql="select * from pro_type where parentid='"+parentid+"'";
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Type> typelist3=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String title=re.getString("typename");
			Type type=new Type(id, title, Integer.parseInt(parentid));
			typelist3.add(type);
		}
		return typelist3;
	}

	public int getTypeid(String title)throws Exception {
		String sql="select * from pro_type where typename='"+title+"'";
		ResultSet re=JDBCUtil.queryAll(sql);
		if(re.next()) {
			Integer id=re.getInt("id");
			return id;
		}
		return 0;
		
	}
}
