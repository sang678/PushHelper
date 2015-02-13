package com.humuson.pushhelper.service;

import java.util.List;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.bean.SmsStatistics;

public interface PushHelperService {
	
	
	//Push 
	public int insertPushList(Push psBean);
	public int insertPushRaw(Push psBean);
	public int insertPushPms(Push psBean);
	
	// result
	public List<Push> selectListResult(int seq);
	public Push selectTotalCnt(int seq);
	public List<Push> selectDetailResult(String reqUid);
	
	
	public int smsSendConfirmMessage(Sms smsBean);
	
	//SMS Inside DB
	public int insertSendInfo(Sms smsBean);
	public int insertSendDetailInfo(Sms smsBean);
	public List<String> selectTarget(String group_key);
	public List<SmsStatistics> selectSmsStatistics(SmsStatistics smsStatisticsBean);
	public SmsStatistics selectResultSum(SmsStatistics smsStatisticsBean);
	public List<Sms> selectDetailInfoList(SmsStatistics smsStatisticsBean);
	public int selectDetailInfoCount(SmsStatistics smsStatisticsBean);
	public SmsStatistics selectStatisticsUseGroupKey(String groupKey);
}
