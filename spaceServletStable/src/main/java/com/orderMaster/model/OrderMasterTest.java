package com.orderMaster.model;

import com.orderDetail.model.OrderDetailDAO;
import com.orderDetail.model.OrderDetailDAOInterface;
import com.orderDetail.model.OrderDetailService;
import com.orderDetail.model.OrderDetailVO;

import java.util.List;


public class OrderMasterTest {

	

		public static void main(String[] args) {
		
			OrderDetailDAOInterface dao = new OrderDetailDAO();
			
			//All
//			List<OrderDetailVO> list = dao.selectAll();
//			for(OrderDetailVO orderDetailVO : list) {
//				System.out.println(orderDetailVO.getOrderMasterId());
//			}		
			
			//AllByMaster
//			OrderDetailService ods = new OrderDetailService();
//			List<OrderDetailVO> list = ods.selectAllOrderDetailByMaster("202009190001");
//			for(OrderDetailVO orderDetailVO : list) {
//				System.out.println(orderDetailVO.getOrderDetailId());
//			}		
			
			//One
			OrderDetailVO one = dao.selectOne("OD0000001");
			System.out.println(one.getOrderMasterId());
			
			//insert
//			OrderDetailVO add = new OrderDetailVO();
//			add.setOrderMasterId("30");
//			add.setSpaceDetailId("30");
//			dao.insert(add);
//			System.out.println("FUCK");
			
			//delete
//			dao.delete("20");
//			System.out.println("FUCK");
			
			//update
//			OrderDetailVO update = new OrderDetailVO();
//			update.setOrderDetailId("20");
//			update.setOrderMasterId("30");
//			update.setSpaceDetailId("30");
//			dao.update(update);
//			System.out.println("FUCK");
			
		}

	

}