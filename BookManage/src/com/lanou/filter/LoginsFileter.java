package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginsFileter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest req=(HttpServletRequest) request;
//		HttpServletResponse resp=(HttpServletResponse) response;
//		String uri=req.getRequestURI();
//		if(uri.endsWith("login.html")|| uri.contains("/user/") ||uri.endsWith("adminLogin") ||uri.contains("/js/")||uri.contains("/css/")||uri.contains("/fonts/")||uri.contains("/img/")) {
//			chain.doFilter(req, resp);
//		}else {
//			HttpSession session=req.getSession();
//			Object obj=session.getAttribute("admin");
//			Object obj1=session.getAttribute("user");
//			if(obj!=null ||obj1!=null) {
//				chain.doFilter(req, resp); 
//				return;
//			}else {
//				resp.sendRedirect("/BookManage/admin/login.html");
//			}
//		}
		
		chain.doFilter(request, response);
	}

}
