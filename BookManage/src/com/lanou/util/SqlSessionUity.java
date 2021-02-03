package com.lanou.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUity {
	
	public static<T> Object getSqlSession(Class<T> t){
		String resource = "mybatis-config.xml";
		Object o=null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession(true);
			o=session.getMapper(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
