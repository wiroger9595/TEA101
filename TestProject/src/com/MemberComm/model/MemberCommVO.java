package com.MemberComm.model;

public class MemberCommVO {
	private String memberCommlId;
	private String memberAId;
	private String memberBId;
	private String Comm;
	private Integer CommLevel;
	private java.sql.Date CommDate;
	
	public String getMemberCommlId() {
		return memberCommlId;
	}
	public void setMemberCommlId(String memberCommlId) {
		this.memberCommlId = memberCommlId;
	}
	public String getMemberAId() {
		return memberAId;
	}
	public void setMemberAId(String memberAId) {
		this.memberAId = memberAId;
	}
	public String getMemberBId() {
		return memberBId;
	}
	public void setMemberBId(String memberBId) {
		this.memberBId = memberBId;
	}
	public String getComm() {
		return Comm;
	}
	public void setComm(String comm) {
		Comm = comm;
	}
	public Integer getCommLevel() {
		return CommLevel;
	}
	public void setCommLevel(Integer commLevel) {
		CommLevel = commLevel;
	}
	public java.sql.Date getCommDate() {
		return CommDate;
	}
	public void setCommDate(java.sql.Date commDate) {
		CommDate = commDate;
	}
	
	@Override
	public String toString() {
		return "MemberCommVO [memberCommlId=" + memberCommlId + ", memberAId=" + memberAId + ", memberBId=" + memberBId
				+ ", Comm=" + Comm + ", CommLevel=" + CommLevel + ", CommDate=" + CommDate + "]";
	}

	
}
