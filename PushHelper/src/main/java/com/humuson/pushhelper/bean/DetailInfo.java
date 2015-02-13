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
	public DetailInfo(String custId, String reqUid, String regDate,
			String ressultTime, String readTime, String clickTime,
			String smsMessage, String pushMessage, String sendDate,
			String rsltDate, String resCd) {
		this.custId = custId;
		this.reqUid = reqUid;
		this.regDate = regDate;
		this.resultTime = ressultTime;
		this.readTime = readTime;
		this.clickTime = clickTime;
		this.smsMessage = smsMessage;
		this.pushMessage = pushMessage;
		this.sentDate = sendDate;
		this.rsltDate = rsltDate;
		this.resCd = resCd;
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

	public DetailInfo() {
		super();
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRessultTime() {
		return resultTime;
	}
	public void setRessultTime(String ressultTime) {
		this.resultTime = ressultTime;
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
	public String getSendDate() {
		return sentDate;
	}
	public void setSendDate(String sendDate) {
		this.sentDate = sendDate;
	}
	public String getRsltDate() {
		return rsltDate;
	}
	public void setRsltDate(String rsltDate) {
		this.rsltDate = rsltDate;
	}
	@Override
	public String toString() {
		return "DetailInfo [custId=" + custId + ", reqUid=" + reqUid
				+ ", regDate=" + regDate + ", ressultTime=" + resultTime
				+ ", readTime=" + readTime + ", clickTime=" + clickTime
				+ ", smsMessage=" + smsMessage + ", pushMessage=" + pushMessage
				+ ", sendDate=" + sentDate + ", rsltDate=" + rsltDate + "]";
	}
	
	
}
