package com.lanou.service;

import java.util.List;

import com.lanou.Dao.ChartDaoImp;
import com.lanou.Dao.IChartDao;
import com.lanou.bean.Chart;

public class ChartServiceImp implements IChartService {

	private IChartDao chartDao=new ChartDaoImp();
	@Override
	public List<Chart> getAll(int pagenum, int pagecount) throws Exception {
		
		return chartDao.getAll(pagenum, pagecount);
	}
	@Override
	public int getCount() throws Exception {
		
		return chartDao.getCount();
	}
	@Override
	public void getDelete(String id) throws Exception {
		
		chartDao.getDelete(id);
	}
	@Override
	public List<Chart> getAll(String userid) throws Exception {
		
		return chartDao.getAll(userid);
	}
	@Override
	public void getAdd(String userid, String productid) throws Exception {
		
		chartDao.getAdd(userid, productid);
	}

}
