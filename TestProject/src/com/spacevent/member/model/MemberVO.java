package com.spacevent.member.model;

import java.sql.Date;
import java.util.Arrays;

public class MemberVO {

	
	
	private String member_id;
	private String member_account;
	private String member_password;
	private String member_name;
	private String member_nickname;
	private String member_email;
	private byte[] member_photo;
	private String member_photo_string;
	private String member_phone;
	private String member_address;
	private Date member_birth;
	private String member_sex;
	private String member_country;
	private Date member_signup_date;
	private String member_job;
	private Integer member_auth;
	private String member_status;
	
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public byte[] getMember_photo() {
		return member_photo;
	}
	public void setMember_photo(byte[] member_photo) {
		this.member_photo = member_photo;
	}
	public String getMember_photo_string() {
		return member_photo_string;
	}
	public void setMember_photo_string(String member_photo_string) {
		this.member_photo_string = member_photo_string;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public Date getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_sex() {
		return member_sex;
	}
	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}
	public String getMember_country() {
		return member_country;
	}
	public void setMember_country(String member_country) {
		this.member_country = member_country;
	}

	
	
	
	public Date getMember_signup_date() {
		return member_signup_date;
	}
	public void setMember_signup_date(Date member_signup_date) {
		this.member_signup_date = member_signup_date;
	}
	public String getMember_job() {
		return member_job;
	}
	public void setMember_job(String member_job) {
		this.member_job = member_job;
	}
	public int getMember_auth() {
		return member_auth;
	}
	public void setMember_auth(int member_auth2) {
		this.member_auth = member_auth2;
	}
	public String getMember_status() {
		return member_status;
	}
	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}
	
	
	
//	@Override
//	public String toString() {
//		return "MemberVO [member_id=" + member_id + ", member_account=" + member_account + ", member_password="
//				+ member_password + ", member_name=" + member_name + ", member_nickname=" + member_nickname
//				+ ", member_email=" + member_email + ", member_photo=" + Arrays.toString(member_photo)
//				+ ", member_photo_string=" + member_photo_string + ", member_phone=" + member_phone
//				+ ", member_address=" + member_address + ", member_birth=" + member_birth + ", member_sex=" + member_sex
//				+ ", member_country=" + member_country + ", member_signup_date=" + member_signup_date + ", member_job="
//				+ member_job + ", member_auth=" + member_auth + ", member_status=" + member_status + "]";
//	}
	
	
	
	

}
