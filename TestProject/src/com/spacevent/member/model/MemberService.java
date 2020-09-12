package com.spacevent.member.model;

import java.sql.Date;
import java.util.List;

public class MemberService {
	
	
	private Member_interface dao;
	
//	public MemberVO addMember(String member_id, String member_account, String member_password, String member_name, String member_nickname,
//							  String member_email, byte[] member_photo, String member_phone, String member_address, Date member_birth,
//							  String member_sex, String member_country, Date member_signup_date, int member_auth, String member_status) {
//		
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMember_id(member_id);
//		memberVO.setMember_account(member_account);
//		memberVO.setMember_password(member_password);
//		memberVO.setMember_name(member_name);
//		memberVO.setMember_nickname(member_nickname);
//		memberVO.setMember_email(member_email);
//		memberVO.setMember_photo(member_photo);
//		memberVO.setMember_phone(member_phone);
////		memberVO.setMember_photo_string(member_photo_string);
//		memberVO.setMember_address(member_address);
//		memberVO.setMember_birth(member_birth);
//		memberVO.setMember_sex(member_sex);
//		memberVO.setMember_country(member_country);
//		memberVO.setMember_signup_date(member_signup_date);
//		memberVO.setMember_auth(member_auth);
//		memberVO.setMember_status(member_status);
//		
//		dao.insert(memberVO);
//		
//		return memberVO;
//		
//		
//		
//		
//	}

	
//	public MemberVO updateMember(String member_id, String member_account, String member_password, String member_name, String member_nickname,
//			  String member_email, byte[] member_photo, String member_phone, String member_address, Date member_birth,
//			  String member_sex, String member_country, Date member_signup_date, int member_auth, String member_status) {
//
//				MemberVO memberVO = new MemberVO();
//				
//				memberVO.setMember_id(member_id);
//				memberVO.setMember_account(member_account);
//				memberVO.setMember_password(member_password);
//				memberVO.setMember_name(member_name);
//				memberVO.setMember_nickname(member_nickname);
//				memberVO.setMember_email(member_email);
//				memberVO.setMember_photo(member_photo);
//				memberVO.setMember_phone(member_phone);
////				memberVO.setMember_photo_string(member_photo_string);
//				memberVO.setMember_address(member_address);
//				memberVO.setMember_birth(member_birth);
//				memberVO.setMember_sex(member_sex);
//				memberVO.setMember_country(member_country);
//				memberVO.setMember_signup_date(member_signup_date);
//				memberVO.setMember_auth(member_auth);
//				memberVO.setMember_status(member_status);
//				
//				dao.update(memberVO);
//				
//				return memberVO;
//
//		}
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}
	
	
	
	
	public void deleteMember(String member_id) {
			dao.delete(member_id);
		}
	
	
	public MemberVO getOneMember(String member_id) {
		return dao.findByPrimaryKey(member_id);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}

	public MemberVO addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		dao.insert(memberVO);
		return memberVO;
	}


	public MemberVO updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		dao.update(memberVO);
		return memberVO;
	}


	
	
	
	
}
