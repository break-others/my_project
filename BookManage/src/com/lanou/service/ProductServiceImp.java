package com.lanou.service;

import java.util.List;

import com.lanou.Dao.IProductDao;
import com.lanou.Dao.ITypeDao;
import com.lanou.Dao.ProductDaoImp;
import com.lanou.Dao.TypeDaoImp;
import com.lanou.bean.Product;
import com.lanou.bean.Type;

public class ProductServiceImp implements IProductService {

	private IProductDao preDao=new ProductDaoImp();
	private ITypeDao typeDao=new TypeDaoImp();
	@Override
	public List<Product> getAll(int pagenum, int pagecount) throws Exception {
		
		return preDao.getAll(pagenum, pagecount);
	}
	@Override
	public int getCount() throws Exception {
		
		return preDao.getCount();
	}
	@Override
	public void getDelete(String id) throws Exception {
		preDao.getDelete(id);
		
	}
	@Override
	public void getAdd(String pname, String pimg, Double price, String title, String pv, String typid)
			throws Exception {
		
		preDao.getAdd(pname, pimg, price, title, pv, typid);
	}
	@Override
	public void getEdit(String id,String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		
		preDao.getEdit(id,pname, pimg, price, ptitle, pv, typeid);
	}
	@Override
	public List<Product> getPro(String typeid) throws Exception {
		
		return preDao.getPro(typeid);
	}
	@Override
	public List<Product> getPro() throws Exception {
		
		return preDao.getPro();
	}
	@Override
	public List<Product> getProList(String pname) throws Exception {
		
		return preDao.getProList(pname);
	}
	@Override
	public List<Product> getByID(int id) throws Exception {
		
		return preDao.getByID(id);
	}
	@Override
	public int getTypeID(String id) throws Exception {
		
		return preDao.getTypeID(id);
	}
	

}
