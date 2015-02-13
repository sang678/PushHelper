package com.humuson.pushhelper.bean;

import java.io.Serializable;

public class SmsStatistics implements Serializable{
	
	private int st_seq;
	private String sms_txt;
	private int send_success;
	private int send_fail;
	private int mb_seq;
	private String group_key;
	private String call_from;
	private String st_time;
	private String st_progress;
	
	public SmsStatistics() {
		// TODO Auto-generated constructor stub
	}

	public SmsStatistics(int st_seq, String sms_txt, int send_success,
			int send_fail, int mb_seq, String group_key, String call_from,
			String st_time, String st_progress) {
		super();
		this.st_seq = st_seq;
		this.sms_txt = sms_txt;
		this.send_success = send_success;
		this.send_fail = send_fail;
		this.mb_seq = mb_seq;
		this.group_key = group_key;
		this.call_from = call_from;
		this.st_time = st_time;
		this.st_progress = st_progress;
	}

	public int getSt_seq() {
		return st_seq;
	}

	public void setSt_seq(int st_seq) {
		this.st_seq = st_seq;
	}

	public String getSms_txt() {
		return sms_txt;
	}

	public void setSms_txt(String sms_txt) {
		this.sms_txt = sms_txt;
	}

	public int getSend_success() {
		return send_success;
	}

	public void setSend_success(int send_success) {
		this.send_success = send_success;
	}

	public int getSend_fail() {
		return send_fail;
	}

	public void setSend_fail(int send_fail) {
		this.send_fail = send_fail;
	}

	public int getMb_seq() {
		return mb_seq;
	}

	public void setMb_seq(int mb_seq) {
		this.mb_seq = mb_seq;
	}

	public String getGroup_key() {
		return group_key;
	}

	public void setGroup_key(String group_key) {
		this.group_key = group_key;
	}

	public String getCall_from() {
		return call_from;
	}

	public void setCall_from(String call_from) {
		this.call_from = call_from;
	}

	public String getSt_time() {
		return st_time;
	}

	public void setSt_time(String st_time) {
		this.st_time = st_time;
	}

	public String getSt_progress() {
		return st_progress;
	}

	public void setSt_progress(String st_progress) {
		this.st_progress = st_progress;
	}
	
	
	

}
