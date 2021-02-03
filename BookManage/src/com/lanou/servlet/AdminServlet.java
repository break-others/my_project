package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.AdminUser;
import com.lanou.service.AdminUserServiceImp;
import com.lanou.service.IAdminUserService;
import com.lanou.util.JSONBean;

public class AdminServlet extends HttpServlet {

	
	private IAdminUserService adminservice=new AdminUserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null || op.equals("")) {
			String pagenum=req.getParameter("page");
			String pagecount =req.getParameter("limit");
			resp.setContentType("text/html;charset=utf-8");
			try {
				List<AdminUser> adminlist=adminservice.getQuery(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				int count=adminservice.getCount();
				String msg="";
				JSONBean jb=new JSONBean("0", msg, count, adminlist);
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id=req.getParameter("id");
			try {
				adminservice.getDelete(id);
				String msg="";
				JSONBean jb=new JSONBean("200", msg, null, null);
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op.equals("add")) {
			String adminname=req.getParameter("adminname");
			String pwd=req.getParameter("pwd");
			try {
				resp.setContentType("text/html;charset=utf-8");
				adminservice.getAdd(adminname, pwd);
				String msg="";
				JSONBean jb=new JSONBean("200", msg, null, null);
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")) {
			String adminname=req.getParameter("adminname");
			String pwd=req.getParameter("pwd");
			String id=req.getParameter("id");
			resp.setContentType("text/html;charset=utf-8");
			try {
				adminservice.getEdit(id,adminname, pwd);
				String msg="";
				JSONBean jb=new JSONBean("200", msg, null, null);
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
