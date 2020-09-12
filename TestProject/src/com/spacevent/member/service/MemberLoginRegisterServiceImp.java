package com.spacevent.member.service;

import com.spacevent.member.model.MemberJDBCDAO;
import com.spacevent.member.model.MemberVO;
import com.spacevent.member.model.Member_interface;

public class MemberLoginRegisterServiceImp  implements MemberLoginRegisterService{

	
	Member_interface memberJDBCDAO = new MemberJDBCDAO();
	
	@Override
	public boolean login(MemberVO memberVO) {
		
		MemberVO dbMember = memberJDBCDAO.findByPrimaryKey(memberVO.getMember_account());
		
		if(dbMember.getMember_password().equals(memberVO.getMember_password())) {
			
			memberVO.setMember_birth(dbMember.getMember_birth());
			memberVO.setMember_address(dbMember.getMember_address());
			memberVO.setMember_phone(dbMember.getMember_phone());
			memberVO.setMember_birth(dbMember.getMember_birth());
			
			return true;
		}
		return false;

	}

	@Override
	public void register(MemberVO memberVO) throws ServiceException {
		// TODO Auto-generated method stub
		
		
		MemberVO dbMember = memberJDBCDAO.findByPrimaryKey(memberVO.getMember_account());
		
		if(dbMember != null) {
			throw new ServiceException("Member Id" + memberVO.getMember_account() + "already exist");
		}
	}

}
