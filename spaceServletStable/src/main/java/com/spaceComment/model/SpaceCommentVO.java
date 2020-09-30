package com.spaceComment.model;

public class SpaceCommentVO {
	private String spaceCommentId;
	private String spaceId;
	private String memId;
	private String spaceCommentContent;
	private Double spaceCommentLevel;
	private java.sql.Date spaceCommentDate;
	
	
	public String getSpaceCommentId() {
		return spaceCommentId;
	}
	public void setSpaceCommentId(String spaceCommentId) {
		this.spaceCommentId = spaceCommentId;
	}
	public String getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getSpaceCommentContent() {
		return spaceCommentContent;
	}
	public void setSpaceCommentContent(String spaceCommentContent) {
		this.spaceCommentContent = spaceCommentContent;
	}
	public Double getSpaceCommentLevel() {
		return spaceCommentLevel;
	}
	public void setSpaceCommentLevel(Double spaceCommentLevel) {
		this.spaceCommentLevel = spaceCommentLevel;
	}
	public java.sql.Date getSpaceCommentDate() {
		return spaceCommentDate;
	}
	public void setSpaceCommentDate(java.sql.Date spaceCommentDate) {
		this.spaceCommentDate = spaceCommentDate;
	}
}
