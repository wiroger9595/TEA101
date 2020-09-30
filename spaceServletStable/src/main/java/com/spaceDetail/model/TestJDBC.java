package com.spaceDetail.model;

import java.util.List;

public class TestJDBC {
	public static void main(String[] args) {
	
		SpaceDetailDAOInterface dao = new SpaceDetailDAO();
		
		//All
//		List<SpaceDetailVO> list = dao.selectAll();
//		for(SpaceDetailVO spaceDetailVO : list) {
//			System.out.println(spaceDetailVO.getSpaceDetailId());
//		}		
		
		//One
		SpaceDetailVO one = dao.selectOne("SD00002");
		System.out.println(one.getSpaceDetailId());
		System.out.println("YOOOO"+one.getSpaceDetailCharge());
		
		
		//insert
//		SpaceDetailVO add = new SpaceDetailVO();
//		add.setSpaceId("SPACE00002");
//		add.setSpaceDetailFreeDate(java.sql.Date.valueOf("2020-09-06"));
//
//		add.setSpaceDetailCharge(50);
//		dao.insert(add);
//		System.out.println("FUCK");
		
		//delete
//		dao.delete("40");
//		System.out.println("FUCK");
		
		//update
//		SpaceDetailVO update = new SpaceDetailVO();
//		update.setSpaceDetailId("70");
//		update.setSpaceId("40");
//		update.setSpaceDetailFreeDate(java.sql.Date.valueOf("2020-09-06"));
//		update.setSpaceDetailFreeTimeStart(java.sql.Timestamp.valueOf("2020-09-03 00:00:00"));
//		update.setSpaceDetailFreeTimeEnd(java.sql.Timestamp.valueOf("2020-09-03 08:00:00"));
//		update.setSpaceDetailCharge(50);
//		dao.update(update);
//		System.out.println("FUCK");
		
	}

}
