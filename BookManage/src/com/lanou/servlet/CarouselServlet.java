package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Carousel;
import com.lanou.service.CarouselServiceImp;
import com.lanou.service.ICarouselService;
import com.lanou.util.JSONBean;

public class CarouselServlet extends HttpServlet {

	private ICarouselService carService=new CarouselServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null||op.equals("")) {
			try {
				String pagenum=req.getParameter("page");
				String pagecount=req.getParameter("limit");
				int count=carService.getCount();
				List<Carousel> carlist=carService.getQuery(Integer.parseInt(pagenum),Integer.parseInt(pagecount));
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				JSONBean jb = new JSONBean("0", "", count, carlist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id=req.getParameter("id");
			try {
				carService.getDelete(id);
				PrintWriter pw = resp.getWriter();
				JSONBean jb = new JSONBean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 }
	
	
}
