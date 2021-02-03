package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONToken;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.service.ChartServiceImp;
import com.lanou.service.IChartService;
import com.lanou.service.IProductService;
import com.lanou.service.ProductServiceImp;
import com.lanou.util.JDBCUtil;
import com.lanou.util.JSONBean;

public class ProductServlet  extends HttpServlet{

	private IProductService proService=new ProductServiceImp();
	private IChartService chartService=new ChartServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null||op.equals("")) {
			resp.setContentType("text/html;charset=utf-8");
			String pagenum=req.getParameter("page");
			String pagecount=req.getParameter("limit");
			try {
				int count=proService.getCount();
				List<Product> prolist=proService.getAll(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JSONBean jb=new JSONBean("0", "", count, prolist);
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
				System.out.println(id);
				proService.getDelete(id);
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
			if(op==null){
				
				Part part=req.getPart("formFile");
				String imgs=part.getSubmittedFileName();
				String lastimg=imgs.substring(imgs.lastIndexOf("."), imgs.length());
				UUID uuid=UUID.randomUUID();
				String imgname =uuid.toString()+lastimg;
				String path=req.getServletContext().getRealPath("");
				path=path.substring(0, path.lastIndexOf("\\"));
				path=path.substring(0, path.lastIndexOf("\\"));
				path=path+File.separator+"upfile"+File.separator;
				File f=new File(path);
				if(f.exists()) {
					
				}else {
					f.mkdir();
				}
				
				part.write(path+imgname);
				PrintWriter pw=resp.getWriter();
				pw.write(imgname);
				pw.flush();
				pw.close();
			}else

			 if(op.equals("edits")) {		
				String id=req.getParameter("id");
				String pname=req.getParameter("pname");
				String price =req.getParameter("price");
				String ptitle=req.getParameter("ptitle");
				String pv=req.getParameter("pv");
				String typeid=req.getParameter("districtId"); 
				String imgnames=req.getParameter("proname");
				try {
					proService.getEdit(id,pname, imgnames, price, ptitle, pv, typeid);
					JSONBean jb=new JSONBean("200", "", null, null);
					String jsonstr=JSON.toJSONString(jb);
					PrintWriter pw=resp.getWriter();
					pw=resp.getWriter();
					pw.write(jsonstr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
		else if(op.equals("add")) {
			String pname=req.getParameter("pname");
			Part part=req.getPart("imgs");
			String price =req.getParameter("price");
			String ptitle=req.getParameter("ptitle");
			String pv=req.getParameter("pv");
			String title=req.getParameter("title");
			String imgs=part.getSubmittedFileName();
			String lastimg=imgs.substring(imgs.lastIndexOf("."), imgs.length());
			UUID uuid=UUID.randomUUID();
			String imgname =uuid.toString()+lastimg;
			String path=req.getServletContext().getRealPath("");
			path=path.substring(0, path.lastIndexOf("\\"));
			path=path.substring(0, path.lastIndexOf("\\"));
			path=path+File.separator+"upfile"+File.separator;
			File f=new File(path);
			if(f.exists()) {
				
			}else {
				f.mkdir();
			}
			
			part.write(path+imgname);
			PrintWriter pw=resp.getWriter();
			pw.write(imgname);
			pw.flush();
			pw.close();
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				proService.getAdd(pname, imgname, Double.parseDouble(price), ptitle, pv, title);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(op.equals("ad")) {
			PrintWriter pw=resp.getWriter();
			JSONBean jb=new JSONBean("200", "", null, null);
			String jsonstr=JSON.toJSONString(jb);
			pw.write(jsonstr);
		} else if(op.equals("par")) {
			String typeid=req.getParameter("tid");
			try {
				List<Product> prolist=proService.getPro(typeid);
				JSONBean jb=new JSONBean("200", "", null, prolist);
				resp.setContentType("text/html;charset=utf-8");
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("pare")) {
			
			try {
				List<Product> prolist=proService.getPro();
				JSONBean jb=new JSONBean("200", "", null, prolist);
				resp.setContentType("text/html;charset=utf-8");
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("sou")) {
			String pname=req.getParameter("pname");
			try {
				List<Product> prolist=proService.getProList(pname);
				JSONBean jb=new JSONBean("200", "", null, prolist);
				resp.setContentType("text/html;charset=utf-8");
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("cha")) {
			String id=req.getParameter("id");
			try {
				List<Product> prolist =proService.getByID(Integer.parseInt(id));
				JSONBean jb=new JSONBean("200", "", null, prolist);
				resp.setContentType("text/html;charset=utf-8");
				String jsonstr=JSON.toJSONString(jb);
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("gouwu")) {
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
			String productid=req.getParameter("productid");
			try {
				chartService.getAdd(userid, productid);
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

}
