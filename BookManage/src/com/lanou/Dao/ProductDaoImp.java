package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class ProductDaoImp implements IProductDao {

	
	private ITypeDao typeDao=new TypeDaoImp();
	@Override
	public List<Product> getAll(int pagenum, int pagecount) throws Exception {
		String sql="select * from t_product limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Product> prolist=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String pname=re.getString("pname");
			String pimg=re.getString("pimg");
			Double price=re.getDouble("price");
			String ptitle=re.getString("ptitle");
			Integer pv=re.getInt("pv");
			String typeid=re.getString("typeid");
			Type type3=typeDao.getType(Integer.parseInt(typeid));
			Type type2=typeDao.getType(type3.getParentid());
			Type type1=typeDao.getType(type2.getParentid());
			String names=type1.getTitle()+"->"+type2.getTitle()+"->"+type3.getTitle();
		
			
			Product por=new Product(id, pname, pimg, price, ptitle, pv, names);
			prolist.add(por);
		}
		return prolist;
	}

	@Override
	public int getCount() throws Exception {
		String sql="select count(id) count from t_product";
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			int count=re.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void getDelete(String id) throws Exception {
		String sql="delete from t_product where id="+id+"";
		JDBCUtil.zhengShanGai(sql);
		
	}

	@Override
	public void getAdd(String pname, String pimg, Double price, String title, String pv, String typid)
			throws Exception {
		String sql="insert into t_product (pname,pimg,price,ptitle,pv,typeid) values ('"+pname+"','"+pimg+"','"+price+"','"+title+"','"+pv+"','"+typid+"')";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getEdit(String id,String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		String sql="update t_product set pname='"+pname+"',pimg='"+pimg+"',price='"+price+"',ptitle='"+ptitle+"',pv='"+pv+"',typeid='"+typeid+"' where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public List<Product> getPro(String typeid) throws Exception {
		String sql="select * from t_product where typeid='"+typeid+"'";
		List<Product> prolist=new ArrayList<>();
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			Integer id=re.getInt("id");
			String pname=re.getString("pname");
			String pimg=re.getString("pimg");
			Double price=re.getDouble("price");
			Product product=new Product(id,pname, pimg, price); 
			prolist.add(product);
		}
		return prolist;
	}

	@Override
	public List<Product> getPro() throws Exception {
		String sql="select * from t_product ";
		List<Product> prolist=new ArrayList<>();
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			Integer id=re.getInt("id");
			String pname=re.getString("pname");
			String pimg=re.getString("pimg");
			Double price=re.getDouble("price");
			Product product=new Product(id,pname, pimg, price); 
			prolist.add(product);
		}
		return prolist;
	}

	@Override
	public List<Product> getProList(String name) throws Exception {
		String sql="select * from t_product where pname like '%"+name+"%' ";
		List<Product> prolist=new ArrayList<>();
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			String pname=re.getString("pname");
			String pimg=re.getString("pimg");
			Double price=re.getDouble("price");
			Product product=new Product(pname, pimg, price); 
			prolist.add(product);
		}
		return prolist;	
	}

	@Override
	public List<Product> getByID(int id) throws Exception {
		String sql="select * from t_product where id="+id;
		List<Product> prolist=new ArrayList<>();
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			String pname=re.getString("pname");
			String pimg=re.getString("pimg");
			Double price=re.getDouble("price");
			Product product=new Product(pname, pimg, price); 
			prolist.add(product);
		}
		return prolist;	
	}

	@Override
	public int getTypeID(String id) throws Exception {
		String sql="select * from t_product where id="+id ;
		ResultSet re=JDBCUtil.queryAll(sql);
		while(re.next()) {
			int typeid=re.getInt("typeid");
			return typeid;
		}
		return 0;
	}

	

}
