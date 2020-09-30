package com.maindbcore;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class BaseServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String method = req.getParameter("method");
		
		if (null == method || "".equals(method) || method.trim().contentEquals("")) {
			method = "execute";
		}
		
		Class takeClass = this.getClass();
		
		try {
			Method md = takeClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			
			if(null!= md) {
				String jspPath = (String) md.invoke(this, req, res);
				if(null != jspPath) {
					req.getRequestDispatcher(jspPath).forward(req, res);
				}
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String execute (HttpServletRequest req, HttpServletResponse res) throws Exception{
		return null;
	}
	
}
