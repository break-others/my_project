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
import com.lanou.util.JSONBean;

public class TypeServlet extends HttpServlet {

	private ITypeService typeService =new TypeServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if(op==null || op.equals("")) {
			try {
				List<Type> typelist=typeService.getAll();
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				JSONBean jb = new JSONBean("0", "", null, typelist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("action")) {
			String id = req.getParameter("id");
			String title=req.getParameter("title");
			String parentid = req.getParameter("parentid");
			if(id==null||id.equals("")) {
				try {
					typeService.getAdd(title, Integer.parseInt(parentid));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					typeService.getEdit(Integer.parseInt(id), title);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			JSONBean jb = new JSONBean("200", "", null, null);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
			
		}else if(op.equals("dele")) {
			String id = req.getParameter("id");
			try {
				typeService.getDelete(Integer.parseInt(id));
				resp.setContentType("text/html;charset=utf-8");
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
