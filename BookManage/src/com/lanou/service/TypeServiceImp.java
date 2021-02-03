package com.lanou.service;

import java.util.List;

import com.lanou.Dao.ITypeDao;
import com.lanou.Dao.TypeDaoImp;
import com.lanou.bean.Type;

public class TypeServiceImp implements ITypeService {

	private ITypeDao typeDao=new TypeDaoImp();
	@Override
	public List<Type> getAll() throws Exception {
		
		List<Type> list1 = typeDao.getQuery(0);//数据库查出来的
		//list1 国内  国外
		for(Type type : list1){//type 国内 
			List<Type> list2 = typeDao.getQuery(type.getId());
			type.setChildren(list2);//二级类别 放入到一级类别中
			for(Type t :list2){
				List<Type> list3 = typeDao.getQuery(t.getId());
				t.setChildren(list3);
			}	
		}
		return list1;
	}
	@Override
	public void getAdd(String title, int parentid) throws Exception {
		typeDao.getAdd(title, parentid);
		
	}
	@Override
	public void getEdit(int id, String title) throws Exception {
		typeDao.getEdit(id, title);
		
	}
	@Override
	public void getDelete(int id) throws Exception {
		typeDao.getDelete(id);
		
	}
	@Override
	public List<Type> getOneList() throws Exception {
		
		return typeDao.getOneList();
	}
	@Override
	public List<Type> getTwoList(String parentid) throws Exception {

		return typeDao.getTwoList(parentid);
	}
	@Override
	public List<Type> getThreeList(String parentid) throws Exception {
		
		return typeDao.getThreeList(parentid);
	}
	@Override
	public int getTypeid(String title) throws Exception {
		
		return typeDao.getTypeid(title);
	}
	

}
