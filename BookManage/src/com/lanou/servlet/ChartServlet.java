package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Chart;
import com.lanou.service.ChartServiceImp;
import com.lanou.service.IChartService;
import com.lanou.util.JSONBean;

public class ChartServlet extends HttpServlet {

	private IChartService chartService=new ChartServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null ||op.equals("")) {
			String pagenum=req.getParameter("page");
			System.out.println(pagenum);
			String pagecount=req.getParameter("limit");
			System.out.println(pagecount);
			resp.setContentType("text/html;charset=utf-8");
			try {
				List<Chart> chartlist=new ArrayList<>();
				chartlist =chartService.getAll(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JSONBean jb=new JSONBean("", "", chartService.getCount(), chartlist);
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
				chartService.getDelete(id);
				JSONBean jb=new JSONBean("200", "", null, null);
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
		if(op==null||op.equals("")) {
			List<Chart> chartlist=new ArrayList<>();
			try {
				String userid = "";
				Cookie[] cookies=req.getCookies();
				
				if(cookies!=null&&cookies.length!=0){
					for(Cookie c : cookies){
						String key=c.getName();
						if(key.equals("id")){
							userid=c.getValue();
						}
					}
			  }
				chartlist=chartService.getAll(userid);
				String jsonstr=JSON.toJSONString(chartlist);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")){
			
			
		}
		
		
	}
}
