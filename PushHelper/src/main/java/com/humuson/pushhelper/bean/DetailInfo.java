package com.humuson.pushhelper.bean;

import java.util.Date;

public class DetailInfo {
	private String custId;
	private String reqUid;
	private Date regDate;
	private Date resultTime;
	private Date readTime;
	private Date clickTime;
	private String smsMessage;
	private String pushMessage;
	private Date sentDate;
	private Date rsltDate;
	private String resCd;
	private String result;
	
	
	public Date getRsltDate() {
		return rsltDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public Date getClickTime() {
		return clickTime;
	}

	public void setClickTime(Date clickTime) {
		this.clickTime = clickTime;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public void setRsltDate(Date rsltDate) {
		this.rsltDate = rsltDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResCd() {
		return resCd;
	}

	public void setResCd(String resCd) {
		this.resCd = resCd;
	}
	
	

	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getReqUid() {
		return reqUid;
	}
	public void setReqUid(String reqUid) {
		this.reqUid = reqUid;
	}

	
	public String getSmsMessage() {
		return smsMessage;
	}
	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}
	public String getPushMessage() {
		return pushMessage;
	}
	public void setPushMessage(String pushMessage) {
		this.pushMessage = pushMessage;
	}

	public DetailInfo(String custId, String reqUid, Date regDate,
			Date resultTime, Date readTime, Date clickTime, String smsMessage,
			String pushMessage, Date sentDate, Date rsltDate, String resCd,
			String result) {
		super();
		this.custId = custId;
		this.reqUid = reqUid;
		this.regDate = regDate;
		this.resultTime = resultTime;
		this.readTime = readTime;
		this.clickTime = clickTime;
		this.smsMessage = smsMessage;
		this.pushMessage = pushMessage;
		this.sentDate = sentDate;
		this.rsltDate = rsltDate;
		this.resCd = resCd;
		this.result = result;
	}

	public DetailInfo() {
	}
	
	
	
}
