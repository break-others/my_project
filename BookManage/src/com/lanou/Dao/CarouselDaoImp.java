package com.lanou.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Carousel;
import com.lanou.util.JDBCUtil;

public class CarouselDaoImp implements ICarouselDao{

	@Override
	public List<Carousel> getQuery() throws Exception {
		String sql="select * from t_carousel";
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Carousel> acrlist=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String timg=re.getString("timg");
			Carousel acr=new Carousel(id, timg);
			acrlist.add(acr);
		}
		return acrlist;
	}

	@Override
	public List<Carousel> getQuery(int pagenum, int pagecount) throws Exception {
		String sql="select * from t_Carousel limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet re=JDBCUtil.queryAll(sql);
		List<Carousel> acrlist=new ArrayList<>();
		while(re.next()) {
			int id=re.getInt("id");
			String timg=re.getString("timg");
			Carousel acr=new Carousel(id, timg);
			acrlist.add(acr);
		}
		return acrlist;
	}

	@Override
	public void getDelete(String id) throws Exception {
		String sql="delete from t_Carousel where id='"+id+"'";
		JDBCUtil.zhengShanGai(sql);
	}

	@Override
	public void getAdd(String timg) throws Exception {
		String sql="insert into t_Carousel (timg) values ('"+timg+"') ";
		JDBCUtil.zhengShanGai(sql);
		
	}

	@Override
	public int getCount() throws Exception {
		String sql="select count(*) count from t_Carousel";		
		ResultSet re=JDBCUtil.queryAll(sql);
		if(re.next()) {
			Integer count =re.getInt("count");
			return count;
		}
		return 0;
	}

}
