package com.lanou.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

	private static Connection con=null;
	private static Statement st=null;
	private static PreparedStatement pr=null;
	private static ResultSet re=null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://10.10.12.91:3306/ly?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="root";
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static  PreparedStatement dengLu(String sql) throws Exception {
		pr=con.prepareStatement(sql);
		return pr;
		
	}
	
	public static void zhengShanGai(String sql) throws Exception {
		st=con.createStatement();
		st.execute(sql);
	}
	
	public static  ResultSet queryAll(String sql) throws Exception {
		pr=con.prepareStatement(sql);
		re=pr.executeQuery();
		return re;
		
	}
	
	public static ResultSet queryUntil(String sql,Object[] ob) throws Exception {
		pr=con.prepareStatement(sql);
		if(ob!=null&&ob.length>0) {
			for(int i=0;i<ob.length;i++) {
				pr.setObject(i+1, ob[i]);
			}
		}
		re=pr.executeQuery();
		return re;
		}
	
	
	
	public static void closeRes() throws Exception {
			if(con!=null){
				con.close();
			}
			
			if(pr!=null){
				pr.close();
			}
			
			if(st!=null){
				st.close();
			}
			
			if(re!=null){
				re.close();
			}
			
			
		}
	
	
}
