package com.humuson.pushhelper.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;

public class SmsDBMapperImpl  extends SqlSessionDaoSupport implements SmsDBMapper{
	
	@Override
	public int insertSMSSend(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("SMS.insertSMSSend", smsBean);
	}
	
	@Override
	public int  smsSendConfirmMessage(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("SMS.sendConfirmMessage", smsBean);
	}
	
	@Override
	public List<Sms> smsSelectLog(String tableName) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("SMS.selectLog",tableName);
	}
	
	@Override
	public int updateTargetting(String tableName) {
		// TODO Auto-generated method stub
		return getSqlSession().update("SMS.updateTargetting", tableName);
	}
	
	@Override
	public int updateEndTargetSelect(String tableName) {
		// TODO Auto-generated method stub
		return getSqlSession().update("SMS.updateEndTargetSelect", tableName);
	}
	
}
