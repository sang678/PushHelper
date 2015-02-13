package com.humuson.pushhelper.bean;

public class AppUser {
	String custId;
	String flag;
	
	public AppUser() {
		// TODO Auto-generated constructor stub
	}
	
	public AppUser(String custId, String flag) {
		super();
		this.custId = custId;
		this.flag = flag;
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
