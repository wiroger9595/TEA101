package com.space.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestJDBC {
	public static void main(String[] args) {
	
		SpaceDAOInterface dao = new SpaceDAO();
		
//		ByteArrayOutputStream baos = null;
//		try {
//			File file = new File("C:\\Users\\user\\Desktop\\allshit.gif");
//			File file = new File("C:\\Users\\HENRYZ\\Desktop\\zzz.jpg");
//			FileInputStream fis = new FileInputStream(file);
//			baos = new ByteArrayOutputStream();
//			byte[] buffer = new byte[8192];
//			int i;
//			while ((i = fis.read(buffer)) != -1) {
//				baos.write(buffer, 0, i);
//			}
//			baos.close();
//			fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		All
		List<SpaceVO> list = dao.getAll();
		for(SpaceVO spaceVO : list) {
			System.out.println(spaceVO.getSpaceId());
			System.out.println(spaceVO.getMemId());
			System.out.println(spaceVO.getEmpId());
			System.out.println(spaceVO.getSpaceLng());
			System.out.println(spaceVO.getSpaceLat());
			System.out.println(spaceVO.getSpaceName());
		}		
		System.out.println("Test All");
		
		//One
		SpaceVO one = dao.selectOne("SPACE00001");
		System.out.println(one.getSpaceId());
		System.out.println(one.getMemId());
		System.out.println(one.getEmpId());
		System.out.println(one.getSpaceName());
		System.out.println("Test One");
		
		//insert
		SpaceVO add = new SpaceVO();
		add.setMemId("MEM00002");
		add.setEmpId("EMP00004");
		add.setSpaceAddress("SPACE_ADDRESS");
		add.setSpaceLng(123.456);
		add.setSpaceLat(-98.765);
		add.setSpaceName("SPACE_NAME");
		add.setSpaceType("SPACE_TYPE");
		add.setSpaceEquipment("SPACE_EQUMENT");
		add.setSpaceContain("CONTAIN");
		add.setSpaceRule("SPACE_RULE");
		add.setSpaceRefund("SPACE_REFUND");
		add.setSpaceStatus("T");
		add.setSpaceSignupDate(java.sql.Date.valueOf("2020-09-01"));
		add.setSpaceOnsaleDate(java.sql.Date.valueOf("2020-09-02"));
		add.setSpaceOffsaleDate(java.sql.Date.valueOf("2020-09-03"));
		dao.insert(add);
		System.out.println("Data Inserted");
		
		//delete
//		dao.delete("4");
//		System.out.println("Data Deleted");
		
		//update
//		SpaceVO update = new SpaceVO();
//		update.setSpaceId("4");
//		update.setMemId("MEM00002");
//		update.setEmpId("EMP00004");
//		update.setSpaceAddress("NEW_ADDRESS");
//		update.setSpaceLng(123.321);
//		update.setSpaceLat(-94.87);
//		update.setSpaceName("NEW_NAME");
//		update.setSpaceType("NEW_TYPE");
//		update.setSpaceEquipment("NEW_EQUMENT");
//		update.setSpaceContain("NEW");
//		update.setSpaceRule("NEW_RULE");
//		update.setSpaceRefund("NEW_REFUND");
//		update.setSpaceStatus("F");
//		update.setSpaceSignupDate(java.sql.Date.valueOf("2020-09-01"));
//		update.setSpaceOnsaleDate(java.sql.Date.valueOf("2020-09-02"));
//		update.setSpaceOffsaleDate(java.sql.Date.valueOf("2020-09-03"));
//		dao.update(update);
//		System.out.println("data updated");
	}
}
