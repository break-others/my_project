package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.User;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImp;
import com.lanou.util.JSONBean;

public class UserServlet extends HttpServlet {

	private IUserService userservice=new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if( op==null|| op.equals("") ) {
			String pagenum=req.getParameter("page");
			String pagecount=req.getParameter("limit");
			try {
				resp.setContentType("text/html;charset=utf-8");
				List<User> userlist=userservice.getAll(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				req.getSession().setAttribute("userlist", userlist);
				int count=userservice.getCount();
				String msg="";
				JSONBean jb=new JSONBean("0", msg, count, userlist);
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id=req.getParameter("id");
			String msg="";
			JSONBean jb=new JSONBean("200", msg, null, null);
			String jsonstr=JSON.toJSONString(jb);
			PrintWriter pw=resp.getWriter();
			pw.write(jsonstr);
			pw.flush();
			pw.close();
			try {
				userservice.getDelete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null||op.equals("")) {
			resp.setContentType("text/html;charset=utf-8");
			String username=req.getParameter("username");
			String userpwd=req.getParameter("userpwd");
			try {
				User user=userservice.getNameAndPwd(username, userpwd);	
				if(user!=null) {
					int id = user.getId();
					Cookie cname = new Cookie("username", username);
					Cookie cid = new Cookie("id", id+"");
					
					cname.setMaxAge(3600);
					cid.setMaxAge(3600);
				
					resp.addCookie(cname);
					resp.addCookie(cid);
				
					req.getSession().setAttribute("user", user);
					
					PrintWriter pw=resp.getWriter();
					JSONBean jb=new JSONBean("200", "", null, user);
					String jsonstr=JSON.toJSONString(jb);
					pw.write(jsonstr);
					pw.flush();
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(op.equals("add")) {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			String phone=req.getParameter("phone");
			String mail=req.getParameter("mail");
			String adress=req.getParameter("adress");
			resp.setContentType("text/html;charset=utf-8");
			try {
				userservice.getAdd(name, pwd, phone, mail, adress);
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
				String id=req.getParameter("id");
				String name=req.getParameter("name");
				String pwd=req.getParameter("pwd");
				String phone=req.getParameter("phone");
				String mail=req.getParameter("mail");
				String adress=req.getParameter("adress");
				try {
					userservice.getEdit(id, name, pwd, phone, mail, adress);
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
