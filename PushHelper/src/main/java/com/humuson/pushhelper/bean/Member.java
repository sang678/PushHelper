package com.humuson.pushhelper.bean;

import java.io.Serializable;

public class Member implements Serializable {
	
	private int mb_seq;
	private String mb_name;
	private String mb_id;
	private String mb_password;
	private String mb_cellphone;
	private String mb_email;
	private String mb_time;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int mb_seq, String mb_name, String mb_id,
			String mb_password, String mb_cellphone, String mb_email,
			String mb_time) {
		super();
		this.mb_seq = mb_seq;
		this.mb_name = mb_name;
		this.mb_id = mb_id;
		this.mb_password = mb_password;
		this.mb_cellphone = mb_cellphone;
		this.mb_email = mb_email;
		this.mb_time = mb_time;
	}
	
	public int getMb_seq() {
		return mb_seq;
	}
	public void setMb_seq(int mb_seq) {
		this.mb_seq = mb_seq;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_password() {
		return mb_password;
	}
	public void setMb_password(String mb_password) {
		this.mb_password = mb_password;
	}
	public String getMb_cellphone() {
		return mb_cellphone;
	}
	public void setMb_cellphone(String mb_cellphone) {
		this.mb_cellphone = mb_cellphone;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_time() {
		return mb_time;
	}
	public void setMb_time(String mb_time) {
		this.mb_time = mb_time;
	}
	


	
}
