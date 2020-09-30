package com.spaceComment.model;

import java.util.List;


public class TestJDBC {
public static void main(String[] args) {
		
		SpaceCommentDAOInterface dao = new SpaceCommentDAO();
		
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
		
		//All
		List<SpaceCommentVO> list = dao.getAll();
		for(SpaceCommentVO spaceCommentVO : list) {
			System.out.println(spaceCommentVO.getSpaceCommentId());
			System.out.println(spaceCommentVO.getSpaceId());
			System.out.println(spaceCommentVO.getMemId());
			System.out.println(spaceCommentVO.getSpaceCommentContent());
			System.out.println(spaceCommentVO.getSpaceCommentLevel());
			System.out.println(spaceCommentVO.getSpaceCommentDate());
		}		
		System.out.println("Test All");
		
		//One
//		SpaceCommentVO one = dao.selectOne("SCOMMENT00001");
//		System.out.println(one.getSpaceCommentId());
//		System.out.println(one.getSpaceId());
//		System.out.println(one.getMemId());
//		System.out.println(one.getSpaceCommentContent());
//		System.out.println(one.getSpaceCommentLevel());
//		System.out.println(one.getSpaceCommentDate());
//		System.out.println("Test One");
		
		//insert
//		SpaceCommentVO add = new SpaceCommentVO();
//		add.setSpaceId("SPACE00001");
//		add.setMemId("MEM00004");
//		add.setSpaceCommentContent("�Z�ҫܯ�");
//		add.setSpaceCommentLevel(1.5);
//		add.setSpaceCommentDate(java.sql.Date.valueOf("2020-09-21"));
//		dao.insert(add);
//		System.out.println("Data Inserted");
		
		//delete
//		dao.delete("4");
//		System.out.println("Data Deleted");
		
		//update
		SpaceCommentVO update = new SpaceCommentVO();
		update.setSpaceCommentId("SCOMMENT00003");
		update.setSpaceId("SPACE00003");
		update.setMemId("MEM00004");
		update.setSpaceCommentContent("���I�Q���~�A��L�譱���ܦn");
		update.setSpaceCommentLevel(3.5);
		update.setSpaceCommentDate(java.sql.Date.valueOf("2020-08-22"));
		dao.update(update);
		System.out.println("data updated");
	}
}
