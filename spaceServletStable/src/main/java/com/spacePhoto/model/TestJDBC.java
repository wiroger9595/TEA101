package com.spacePhoto.model;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestJDBC {
	public static void main(String[] args) {

		SpacePhotoDAO_interface dao = new SpacePhotoDAO();

		ByteArrayOutputStream baos = null;
//		try {
////			File file = new File("C:\\Users\\HENRYZ\\Desktop\\all_rubbish.jpg");
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

		// All
//		List<SpacePhotoVO> list = dao.getAll();
//		for(SpacePhotoVO spacePhotoVO : list) {
//			System.out.println(spacePhotoVO.getSpacePhotoId());
//			System.out.println(spacePhotoVO.getSpaceId());
//			System.out.println(spacePhotoVO.getSpacePhoto());
//			System.out.println(spacePhotoVO.getSpacePhotoBase64());
//		}		
//		System.out.println("Test All");

		// One
		SpacePhotoVO one = dao.selectOne("SPACEPHOTO0000001");
		System.out.println(one.getSpacePhotoId());
		System.out.println(one.getSpaceId());
		System.out.println(one.getSpacePhoto());
		//System.out.println(one.getSpacePhotoBase64());
		System.out.println("Test One");

		// insert
//		SpacePhotoVO add = new SpacePhotoVO();
//		add.setSpaceId("SPACE00001");
//		add.setSpacePhoto(baos.toByteArray());
//		dao.insert(add);
//		System.out.println("Data Inserted");

		// delete
//		dao.delete("4");
//		System.out.println("Data Deleted");

		// update
//		SpacePhotoVO update = new SpacePhotoVO();
//		update.setSpacePhotoId("SPACEPHOTO0000003");
//		update.setSpaceId("SPACE00002");
//		update.setSpacePhoto(baos.toByteArray());
//		dao.update(update);
//		System.out.println("data updated");

	}
}
