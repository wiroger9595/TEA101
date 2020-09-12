package com.spacevent.member.model;

	import java.io.ByteArrayOutputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.List;


public class TestMember {

		public static void main(String[] args) {
		
			Member_interface dao = new MemberJDBCDAO();
			
			ByteArrayOutputStream baos = null;
			try {
//				File file = new File("C:\\Users\\user\\Desktop\\TEA101G2\\BlobTest1.jpg");
				File file = new File("/Users/robert/Documents/images/IMG_0089.JPG");
				FileInputStream fis = new FileInputStream(file);
				baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[8192];
				int i;
				while ((i = fis.read(buffer)) != -1) {
					baos.write(buffer, 0, i);
				}
				baos.close();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("hello");
			//All
			List<MemberVO> list = dao.getAll();
			for(MemberVO memberVO : list) {
				System.out.println(memberVO.getMember_id());
				System.out.println(memberVO.getMember_name());
				System.out.println(memberVO.getMember_phone());
				System.out.println(memberVO.getMember_photo_string());
			}		
			System.out.println("add all");
			
			//One
			MemberVO one = dao.findByPrimaryKey("MEM445");
			System.out.println(one.getMember_account());
			System.out.println(one.getMember_name());
			System.out.println(one.getMember_phone());
			System.out.println(one.getMember_photo_string());
			System.out.println("get one data");
//			
//			//insert
//			MemberVO add = new MemberVO();
//			add.setMember_id("MEM352");
//			add.setMember_account("GD959359");
//			add.setMember_password("l34j2g");
//			add.setMember_name("king");
//			add.setMember_nickname("rotof");
//			add.setMember_email("rob@ro");
//			add.setMember_photo(baos.toByteArray());
//			add.setMember_phone("435-235-2143");
//			add.setMember_address("台中市北區");
//			add.setMember_birth(java.sql.Date.valueOf("2020-09-01"));
//			add.setMember_sex("M");
//			add.setMember_country("Japan");
//			add.setMember_signup_date(java.sql.Date.valueOf("2020-09-01"));
//			add.setMember_auth(3);
//			add.setMember_status("f");
//			dao.insert(add);
//			System.out.println("insert finish");
//			
//			//delete
//			dao.delete("MEM356");
//			System.out.println("delete done ");
//			
//			//update
			
			
//			MemberVO update = new MemberVO();
//			update.setMember_id("MEM587");
//			update.setMember_account("EMP_ACCOUNT");
//			update.setMember_password("EMP_PASSWORD");
//			update.setMember_name("EMP_NAME");
//			update.setMember_nickname("EMP_NICKNAME");
//			update.setMember_email("EMP_EMAIL");
//			//update.setMember_photo(baos.toByteArray());
//			update.setMember_phone("EMP_PHONE");
//			update.setMember_address("EMP_ADRESS");
//			update.setMember_birth(java.sql.Date.valueOf("2020-09-01"));
//			update.setMember_sex("M");
//			update.setMember_country("EMP_COUNTRY");
//			update.setMember_signup_date(java.sql.Date.valueOf("2020-09-01"));
//			update.setMember_auth(1);
//			update.setMember_status("f");
//			dao.update(update);
//			System.out.println("UPDATE DONE ");
			
			//update

//			MemberVO update = new MemberVO();
//			update.setMember_id("MEM356");
//			update.setMember_account("AB956");
//			update.setMember_password("ADKL3");
//			update.setMember_name("DALALA");
//			update.setMember_nickname("LOLO");
//			update.setMember_email("ko@jlk.co");
//			update.setMember_photo(baos.toByteArray());
//			update.setMember_phone("958-2959");
//			update.setMember_address("Ekdkdk ra");
//			update.setMember_birth(java.sql.Date.valueOf("2020-09-01"));
//			update.setMember_sex("M");
//			update.setMember_country("Jk");
//			update.setMember_signup_date(java.sql.Date.valueOf("2020-09-01"));
//			update.setMember_auth(1);
//			update.setMember_status("f");
//			dao.update(update);
//			System.out.println("UPDATE DONE ");
			
			
		}
		

	}
