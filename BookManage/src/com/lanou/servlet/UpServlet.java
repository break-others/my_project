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

public class UpServlet extends HttpServlet {

	private ICarouselService carService=new CarouselServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part=req.getPart("formFile");
		String imgs=part.getSubmittedFileName();
		String lastimg=imgs.substring(imgs.lastIndexOf("."), imgs.length());
		UUID uuid=UUID.randomUUID();
		String imgname =uuid.toString()+lastimg;
		try {
			carService.getAdd(imgname);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carousel> carlist;
		try {
			carlist = carService.getQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			JSONBean jb = new JSONBean("0", "", 5, carlist);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
