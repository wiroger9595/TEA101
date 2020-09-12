package com.MemberComm.model.TestFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MemberComm.model.MemberCommDAO;
import com.MemberComm.model.MemberCommVO;

public class MemberCommDAOJDBCTest {
	
	
	MemberCommDAO dao;
	@BeforeEach 
	void setUp() {
		dao = new MemberCommDAO();
	}
	
	
	
	@AfterEach
	void tearDown() {
		dao = null;
	}
	
//	@Test
//	void findMainOne() {
//		MemberCommVO memberCommVO = dao.selectOne("COMM237");
//		
//		 Date date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 03).getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//		
//		String strDate = dateFormat.format(date);  
//
//		
//		
//		assertNotNull(memberCommVO);
//		assertEquals("COMM237", memberCommVO.getMemberCommlId());
//		assertEquals("MEM291", memberCommVO.getMemberAId());
//		assertEquals("MEM617", memberCommVO.getMemberBId());
//		assertEquals("感覺很有創意，也很用心在經營", memberCommVO.getComm());
//		assertEquals(95, memberCommVO.getCommLevel().intValue());
//		assertEquals(1599062400000L, memberCommVO.getCommDate().getTime());
//	}
	
	@Test
	void findAll() {
		List<MemberCommVO> list = dao.selectAll();
		assertEquals(list.size(), 6);
	}
	
//	@Test
//	void create() throws ParseException {
//		MemberCommVO memberCommVO = new MemberCommVO();
//	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//	    Date myDate = formatter.parse("1978-10-10");
//	    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
//	    
//	    
//	    
//		memberCommVO.setMemberCommlId("COMM237");
//		memberCommVO.setMemberAId("MEM617");
//		memberCommVO.setMemberBId("MEM445");
//		memberCommVO.setComm("hate it");
//		memberCommVO.setCommLevel(28);
//		memberCommVO.setCommDate(sqlDate);
//		
//		dao.insert(memberCommVO);
		
		//find pimary key
//	    java.sql.Date sqlDate1 = new java.sql.Date(myDate.getTime());
//
//		
//		MemberCommVO memberCommVO1 = dao.selectOne("COMM297");
//		assertEquals("COMM297", memberCommVO1.getMemberCommlId());
//		assertEquals("MEM617", memberCommVO1.getMemberAId());
//		assertEquals("MEM445", memberCommVO1.getMemberBId());
//		assertEquals("hate it", memberCommVO1.getComm());
//		assertEquals(28, memberCommVO1.getCommLevel().intValue());
//		assertEquals(sqlDate, memberCommVO1.getCommDate().getTime());
//	}
//	
	@Test
	void modify() throws ParseException{
		MemberCommVO memberCommVO = new MemberCommVO();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date editDate = formatter.parse("1967-12-13");
	    java.sql.Date sqlDate = new java.sql.Date(editDate.getTime());
		
		
		memberCommVO.setMemberCommlId("110");
		memberCommVO.setMemberAId("MEM617");
		memberCommVO.setMemberBId("MEM445");
		memberCommVO.setComm("hate it");
		memberCommVO.setCommLevel(22);
		memberCommVO.setCommDate( sqlDate);
		
		////////////////////////////////////
		
//		MemberCommVO memberCommVO1 = dao.selectOne("COMM297");
//		assertEquals("COMM297", memberCommVO1.getMemberCommlId());
//		assertEquals("MEM617", memberCommVO1.getMemberAId());
//		assertEquals("MEM445", memberCommVO1.getMemberBId());
//		assertEquals("hate it", memberCommVO1.getComm());
//		assertEquals(28, memberCommVO1.getCommLevel().intValue());
//		assertEquals(sqlDate, memberCommVO1.getCommDate().getTime());
	}
	
	@Test
	void remove() {
		
	}
	
	
}


