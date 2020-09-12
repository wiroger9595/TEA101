package com.spacevent.member.service;

import com.spacevent.member.model.MemberVO;

public interface MemberLoginRegisterService {
	
	/**
	 * 
	 * @param memberVO
	 * @return /// success get true fail get false
	 */
	boolean login(MemberVO memberVO);
	
	/**
	 * 
	 * @param memberVO
	 * @throws ServiceException /// sign up fail throw exception
	 */
	void register(MemberVO memberVO) throws ServiceException;
}
