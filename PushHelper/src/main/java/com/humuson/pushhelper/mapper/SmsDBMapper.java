package com.humuson.pushhelper.mapper;

import java.util.List;

import com.humuson.pushhelper.bean.Sms;

public interface SmsDBMapper {

	public int insertSMSSend(Sms smsBean);
	public int smsSendConfirmMessage(Sms smsBean);
	public List<Sms> smsSelectLog(String tableName);
	public int updateTargetting(String tableName);
	public int updateEndTargetSelect(String tableName);
	
}
