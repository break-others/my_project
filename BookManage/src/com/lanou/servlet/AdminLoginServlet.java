package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.AdminUser;
import com.lanou.service.AdminUserServiceImp;
import com.lanou.service.IAdminUserService;
import com.lanou.util.JSONBean;

public class AdminLoginServlet extends HttpServlet {

	
	private IAdminUserService adminservice=new AdminUserServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminname=req.getParameter("adminname");
		String adminpwd=req.getParameter("password");
		try {
			AdminUser admin=adminservice.getNameAndPwd(adminname, adminpwd);
			req.getSession().setAttribute("admin", admin);
			String msg="";
			JSONBean js=new JSONBean("0", msg, null,null);
			String jsonstr=JSON.toJSONString(js);
			PrintWriter pw=resp.getWriter();
			pw.write(jsonstr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
