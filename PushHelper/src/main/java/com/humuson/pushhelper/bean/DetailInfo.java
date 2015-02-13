package com.humuson.pushhelper.bean;


public class DetailInfo {
	private String custId;
	private String reqUid;
	private String regDate;
	private String resultTime;
	private String readTime;
	private String clickTime;
	private String smsMessage;
	private String pushMessage;
	private String sentDate;
	private String rsltDate;
	private String resCd;
	private String result;

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public String getClickTime() {
		return clickTime;
	}

	public void setClickTime(String clickTime) {
		this.clickTime = clickTime;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getRsltDate() {
		return rsltDate;
	}

	public void setRsltDate(String rsltDate) {
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


	public DetailInfo(String custId, String reqUid, String regDate,
			String resultTime, String readTime, String clickTime,
			String smsMessage, String pushMessage, String sentDate,
			String rsltDate, String resCd, String result) {
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
