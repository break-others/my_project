package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Type;
import com.lanou.service.ITypeService;
import com.lanou.service.TypeServiceImp;

public class DataServlet extends HttpServlet {

	private ITypeService typeService=new TypeServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op.equals("one")) {
			try {
				List<Type> onelist=typeService.getOneList();
				String jsonstr=JSON.toJSONString(onelist);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("two")) {
			String father = req.getParameter("father");
			try {
				List<Type> twolist=typeService.getTwoList(father);
				String jsonstr=JSON.toJSONString(twolist);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonstr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("three")) {
			String father = req.getParameter("father");
			try {
				List<Type> threelist=typeService.getThreeList(father);
				String jsonstr=JSON.toJSONString(threelist);
				resp.setContentType("text/html;charset=utf-8");
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
