package com.humuson.pushhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.bean.SmsStatistics;
import com.humuson.pushhelper.mapper.PushLocalDBMapper;
import com.humuson.pushhelper.mapper.PushPmsDBMapper;
import com.humuson.pushhelper.mapper.SmsDBMapper;
import com.humuson.pushhelper.mapper.SmsInsideDBMapper;

@Service("pushhelperService")
public class PushHelperImpl implements PushHelperService{
	
	@Autowired
	private SmsDBMapper smsDBMapper;

	@Autowired
	private PushLocalDBMapper pushLocalDBMapper;
	
	@Autowired
	private PushPmsDBMapper pushPmsDBMapper;
		
	@Autowired
	private SmsInsideDBMapper smsInsideDBMapper;
	
	
	@Override
	public List<Push> selectDetailResult(String reqUid) {
		// TODO Auto-generated method stub
		return pushLocalDBMapper.selectDetailResult(reqUid);
	}

	// Push
	@Override
	public int insertPushList(Push psBean) {
		// TODO Auto-generated method stub
		return pushLocalDBMapper.insertPushList(psBean);
	}
	
	@Override
	public Push selectTotalCnt(int seq) {
		// TODO Auto-generated method stub
		return pushLocalDBMapper.selectTotalCnt(seq);
	}

	@Override
	public int insertPushRaw(Push psBean) {
		// TODO Auto-generated method stub
		return pushLocalDBMapper.insertPushRaw(psBean);
	}
	
	@Override
	public int insertPushPms(Push psBean) {
		// TODO Auto-generated method stub
		return pushPmsDBMapper.insertPushPms(psBean);
	}

	@Override
	public List<Push> selectListResult(int seq) {
		// TODO Auto-generated method stub
		return pushLocalDBMapper.selectListResult(seq);
	}
	
	
	
	
	
	
	
	
	
	

	// Inside DB
	@Override
	public int insertSendInfo(Sms smsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.insertSendInfo(smsBean);
	}
	@Override
	public int insertSendDetailInfo(Sms smsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.insertSendDetailInfo(smsBean);
	}
	@Override
	public List<String> selectTarget(String group_key) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectTarget(group_key);
	}
	
	@Override
	public int smsSendConfirmMessage(Sms smsBean) {
		// TODO Auto-generated method stub
		return smsDBMapper.smsSendConfirmMessage(smsBean);
	}
	
	@Override
	public SmsStatistics selectResultSum(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectResultSum(smsStatisticsBean);
	}
	
	@Override
	public List<SmsStatistics> selectSmsStatistics(
			SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectStatistics(smsStatisticsBean);
	}
	@Override
	public List<Sms> selectDetailInfoList(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectDetailInfoList(smsStatisticsBean);
	}
	@Override
	public int selectDetailInfoCount(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectDetailInfoCount(smsStatisticsBean);
	}
	@Override
	public SmsStatistics selectStatisticsUseGroupKey(String groupKey) {
		// TODO Auto-generated method stub
		return smsInsideDBMapper.selectStatisticsUseGroupKey(groupKey);
	}

}
