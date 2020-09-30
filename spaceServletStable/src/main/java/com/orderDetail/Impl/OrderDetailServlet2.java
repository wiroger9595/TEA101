package com.orderDetail.Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maindbcore.BaseServlet;
import com.orderDetail.model.OrderDetailVO;

public class OrderDetailServlet2 extends BaseServlet{

	
	public String saveOrder(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		//make sure login status
		
		//order detail 
		OrderDetailVO orderDetalVO = new OrderDetailVO();
		
		
		
		
		return "/frontendPage/orderSecond.jsp";
		
	}
}
