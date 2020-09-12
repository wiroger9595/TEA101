package com.spacevent.member.model;

import java.util.List;

public interface Member_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public void delete(String member_id);

	public MemberVO findByPrimaryKey(String member_id);
	public List<MemberVO> getAll();
}
