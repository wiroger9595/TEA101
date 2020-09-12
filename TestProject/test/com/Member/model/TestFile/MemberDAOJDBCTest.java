package com.Member.model.TestFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MemberComm.model.MemberCommDAO;
import com.spacevent.member.model.MemberJDBCDAO;
import com.spacevent.member.model.MemberVO;

public class MemberDAOJDBCTest {

	
	
	
	MemberJDBCDAO dao;
	@BeforeEach 
	void setUp() {
		dao = new MemberJDBCDAO();
	}
	
	
	
	@AfterEach
	void tearDown() {
		dao = null;
	}
	
//	@Test
//	void findMainOne() {
//		MemberVO memberVO = dao.findByPrimaryKey("MEM445");
//		
//		 Date date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 03).getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//	
//		
//		assertNotNull(memberVO);
//		assertEquals("MEM445", memberVO.getMember_id());
//		assertEquals("CB239876470", memberVO.getMember_account());
//		assertEquals("74Jg4Fp4iaL", memberVO.getMember_password());
//		assertEquals("昆昆", memberVO.getMember_name());
//		assertEquals("Kunun", memberVO.getMember_nickname());
//		assertEquals("sjoesbury7@pbs.org", memberVO.getMember_email());
//		assertEquals(null, memberVO.getMember_photo());
//		assertEquals("372-167-8741", memberVO.getMember_phone());
//		assertEquals("新北市三峽區", memberVO.getMember_address());
//		assertEquals(357667200000L, memberVO.getMember_birth().getTime());
//		assertEquals("M", memberVO.getMember_sex());
//		assertEquals("Philippines", memberVO.getMember_country());
//		assertEquals(1493913600000L, memberVO.getMember_signup_date().getTime());
//		assertEquals(2, memberVO.getMember_auth());
//		assertEquals("T", memberVO.getMember_status());
//
//
//	}
	
//	@Test
//	void findAll() {
//		List<MemberVO> list = dao.getAll();
//		assertEquals(list.size(), 5);
//	}
	
	@Test
	void create() throws ParseException  {
		MemberVO memberVO = new MemberVO();
		
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date myDate = formatter.parse("1978-10-10");
	    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
	    
		ByteArrayOutputStream baos = null;


		try {
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
	    
	    memberVO.setMember_id("MEM342");
	    memberVO.setMember_account("TB2324f4a0");
	    memberVO.setMember_password("43JwioiaL");
	    memberVO.setMember_name("Jordan");
	    memberVO.setMember_nickname("Basket God");
	    memberVO.setMember_email("skingds7@pfss.ow");
	    memberVO.setMember_photo(baos.toByteArray());
	    memberVO.setMember_phone("634-353-2623");
	    memberVO.setMember_address("1412 king st");
	    memberVO.setMember_birth(sqlDate);
	    memberVO.setMember_sex("M");
	    memberVO.setMember_country("USA");
	    memberVO.setMember_signup_date(sqlDate);
	    memberVO.setMember_auth(3);
	    memberVO.setMember_status("T");
	    
	    
		dao.insert(memberVO);
	}
//		//find pimary key
//		MemberVO memberVO1 = dao.selectOne("COMM147");
//		assertEquals("COMM237", memberVO1.getMemberCommlId());
//		assertEquals("MEM291", memberVO1.getMemberAId());
//		assertEquals("MEM617", memberVO1.getMemberBId());
//		assertEquals("感覺很有創意，也很用心在經營", memberVO1.getComm());
//		assertEquals(95, memberVO1.getCommLevel().intValue());
//		assertEquals(1599062400000L, memberVO1.getCommDate().getTime());
//		
//	}
//	
//	@Test
//	void modify() {
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMemberCommlId("COMM949");
//		memberVO.setMemberAId("MEM859");
//		memberVO.setMemberBId("MEM623");
//		memberVO.setComm("hate it");
//		memberVO.setCommLevel(28);
		//memberVO.setCommDate(new Date(1599062400000L));
//	}
	
	@Test
	void remove() {
		
	}
	
}
