package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Chart;
import com.lanou.util.JDBCUtil;

public class ChartDaoImp implements IChartDao {

	@Override
	public List<Chart> getAll(int pagenum, int pagecount) throws Exception {
		String sql="select "
				   + "  tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price  " 
				 + " from t_cart tc left join t_user tu on tc.userid=tu.id "
			     +"  left join t_product tp on tc.productid=tp.id limit "+(pagenum-1)*pagecount+","+pagecount ;
		
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Chart> chartlist=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			Integer userid=re.getInt("userid");
			Integer productid=re.getInt("productid");
			String uname=re.getString("uname");
			String phone=re.getString("phone");
			String pname=re.getString("pname");
			Double price=re.getDouble("price");
			Chart chart=new Chart(id, userid, productid, uname, pname, phone, price);
			chartlist.add(chart);
		}
		return chartlist;
	}

	@Override
	public int getCount() throws Exception {
		String sql="select "
				+" count(*) count  "  
				+"  from t_cart tc left join t_user tu on tc.userid=tu.id "
				+"	 left join t_product tp on tc.productid=tp.id";
		ResultSet re=JDBCUtil.queryAll(sql);
		if(re.next()) {
			Integer count =re.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void getDelete(String id) throws Exception {
		String sql="delete from t_cart where id="+id;
		JDBCUtil.zhengShanGai(sql);
		
	}

	@Override
	public List<Chart> getAll(String userid) throws Exception {
		String sql="select "  
				+" tp.id productid,tp.pname pname,tp.amount amount   " 
				+" from t_cart tc left join t_user tu on tc.userid=tu.id "
				+" left join t_product tp on tc.productid=tp.id where tu.id='"+userid+"' ";
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Chart> chartlist=new ArrayList<>();
		while(re.next()) {
			Integer productid=re.getInt("productid");
			String pname=re.getString("pname");
			Integer amount=re.getInt("amount");
			Chart chart=new Chart(productid, pname, amount);
			chartlist.add(chart);
		}
		return chartlist;
	}

	@Override
	public void getAdd(String userid, String productid) throws Exception {
		String sql1="select * from t_cart where userid=? and productid=?";
		Object[] ob= {userid,productid};
		ResultSet re=JDBCUtil.queryUntil(sql1, ob);
		if(re.next()) {
			String sql2="select * from t_product where id='"+productid+"'";
			ResultSet re1=JDBCUtil.queryAll(sql2);
			if(re1.next()) {
				Integer amount=re1.getInt("amount");
				amount=amount+1;
				String sql3="update t_product set amount="+amount+" where id='"+productid+"'";
				JDBCUtil.zhengShanGai(sql3);
			}
		}else {
			String sql="insert into t_cart (userid,productid) values ("+userid+","+productid+")";
			JDBCUtil.zhengShanGai(sql);
		}
		
		
	}
	
	

}
