package com.lanou.service;

import java.util.List;

import com.lanou.Dao.CarouselDaoImp;
import com.lanou.Dao.ICarouselDao;
import com.lanou.bean.Carousel;

public class CarouselServiceImp implements ICarouselService {

	private ICarouselDao carDao=new CarouselDaoImp();
	@Override
	public List<Carousel> getQuery() throws Exception {
		
		return carDao.getQuery();
	}
	@Override
	public List<Carousel> getQuery(int pagenum, int pagecount) throws Exception {
		
		return carDao.getQuery(pagenum, pagecount);
	}
	@Override
	public void getDelete(String id) throws Exception {
		carDao.getDelete(id);
		
	}
	@Override
	public void getAdd(String timg) throws Exception {
		carDao.getAdd(timg);
		
	}
	@Override
	public int getCount() throws Exception {
		
		return carDao.getCount();
	}

}
