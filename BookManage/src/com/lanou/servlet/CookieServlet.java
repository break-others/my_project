package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.User;
import com.lanou.util.JSONBean;

public class CookieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username="";
		Cookie []cs=req.getCookies();
		if(cs!=null&&cs.length!=0){
			for(Cookie c:cs){
				String key=c.getName();
				if(key.equals("username")){
					username=c.getValue();
					resp.setContentType("text/html;charset=utf-8");
				}
			}
			
		}
			PrintWriter pw = resp.getWriter();
			String jsonStr = JSON.toJSONString(username);
			
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		
	}
}
