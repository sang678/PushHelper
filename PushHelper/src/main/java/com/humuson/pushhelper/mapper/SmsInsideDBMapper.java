package com.humuson.pushhelper.mapper;

import java.util.List;

import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.bean.SmsStatistics;

public interface SmsInsideDBMapper {
	
	public int insertSendInfo(Sms smsBean);
	public int insertSendDetailInfo(Sms smsBean);
	public List<String> selectTarget(String groupKey);
	public int updateSentResult(Sms smsBean);
	
	public List<SmsStatistics> selectStatistics(SmsStatistics smsStatisticsBean);
	public SmsStatistics selectResultSum(SmsStatistics smsStatisticsBean);
	
	public List<Sms> selectDetailInfoList(SmsStatistics smsStatisticsBean);
	public int selectDetailInfoCount(SmsStatistics smsStatisticsBean);
	public SmsStatistics selectStatisticsUseGroupKey(String groupKey);	
	
	public List<String> selectNotEndedGroupKey();
	public int updateStatisticsProgress(String groupKey);
	
}
