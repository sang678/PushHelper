package com.humuson.pushhelper.bean;

import java.io.Serializable;

public class Sms implements Serializable{
	
	private int cur_state;
	private String call_to;
	private String call_from;
	private String sms_txt;
	private int msg_type;
	private String sent_date;
	private String rslt_date;
	private String msg_etc1;
	private String msg_etc2;
	private String msg_etc3;
	private String rslt_code2;

	
	public Sms() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Sms(String call_to, String msg_etc1) {
		this.call_to = call_to;
		this.msg_etc1 = msg_etc1;
	}



	public Sms(int cur_state, String call_to, String call_from, String sms_txt,
			int msg_type, String msg_etc1, String msg_etc2) {
		this.cur_state = cur_state;
		this.call_to = call_to;
		this.call_from = call_from;
		this.sms_txt = sms_txt;
		this.msg_type = msg_type;
		this.msg_etc1 = msg_etc1;
		this.msg_etc2 = msg_etc2;
	}



	public Sms(int cur_state, String call_to, String call_from, String sms_txt,
			int msg_type, String sent_date, String rslt_date, String msg_etc1,
			String msg_etc2, String msg_etc3, String rslt_code2) {
		super();
		this.cur_state = cur_state;
		this.call_to = call_to;
		this.call_from = call_from;
		this.sms_txt = sms_txt;
		this.msg_type = msg_type;
		this.sent_date = sent_date;
		this.rslt_date = rslt_date;
		this.msg_etc1 = msg_etc1;
		this.msg_etc2 = msg_etc2;
		this.msg_etc3 = msg_etc3;
		this.rslt_code2 = rslt_code2;

	}

	public int getCur_state() {
		return cur_state;
	}

	public void setCur_state(int cur_state) {
		this.cur_state = cur_state;
	}

	public String getCall_to() {
		return call_to;
	}

	public void setCall_to(String call_to) {
		this.call_to = call_to;
	}

	public String getCall_from() {
		return call_from;
	}

	public void setCall_from(String call_from) {
		this.call_from = call_from;
	}

	public String getSms_txt() {
		return sms_txt;
	}

	public void setSms_txt(String sms_txt) {
		this.sms_txt = sms_txt;
	}

	public int getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(int msg_type) {
		this.msg_type = msg_type;
	}

	public String getSent_date() {
		return sent_date;
	}

	public void setSent_date(String sent_date) {
		this.sent_date = sent_date;
	}

	public String getRslt_date() {
		return rslt_date;
	}

	public void setRslt_date(String rslt_date) {
		this.rslt_date = rslt_date;
	}

	public String getMsg_etc1() {
		return msg_etc1;
	}

	public void setMsg_etc1(String msg_etc1) {
		this.msg_etc1 = msg_etc1;
	}

	public String getMsg_etc2() {
		return msg_etc2;
	}

	public void setMsg_etc2(String msg_etc2) {
		this.msg_etc2 = msg_etc2;
	}

	public String getMsg_etc3() {
		return msg_etc3;
	}

	public void setMsg_etc3(String msg_etc3) {
		this.msg_etc3 = msg_etc3;
	}

	public String getRslt_code2() {
		return rslt_code2;
	}

	public void setRslt_code2(String rslt_code2) {
		this.rslt_code2 = rslt_code2;
	}


		
	

}
