package com.orderDetail.Impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.maindbcore.JdbcTemplate;
import com.orderDetail.model.OrderDetailDAOInterface;
import com.orderDetail.model.OrderDetailVO;

public class OrderDetailImplJdbc implements OrderDetailDAOInterface{

	String findByPk ="select ORDER_DETAIL_ID, ORDER_MASTER_ID, SPACE_DETAIL_ID, RENT_START_TIME, RENT_END_TIME FROM ORDER_DETAIL WHERE ORDER_DETAIL_ID = ? ";
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Override
	public void insert(OrderDetailVO orderDetailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String orderDetailId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderDetailVO orderDetailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDetailVO selectOne(String orderDetailId) {
		
//		jdbcTemplate.query(new PreparedSDtatementCreator() {
//			@Override
//			PreparedStatement ps = conn.pre
//			
//		}, callbackHandler);
		return null;
	}

	@Override
	public List<OrderDetailVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
