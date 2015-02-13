package com.humuson.pushhelper.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.bean.SmsStatistics;

public class SmsInsideDBMapperImpl extends SqlSessionDaoSupport implements SmsInsideDBMapper {

	@Override
	public int insertSendInfo(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("SMS.insertSendInfo", smsBean);
	}
	
	@Override
	public int insertSendDetailInfo(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("SMS.insertSendDetailInfo", smsBean);
	}
	
	@Override
	public List<String> selectTarget(String group_key) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("SMS.selectTarget",group_key);
	}
	
	@Override
	public int updateSentResult(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("SMS.updateSentResult", smsBean);
	}
	
	@Override
	public SmsStatistics selectResultSum(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SMS.selectResultSum", smsStatisticsBean);
	}
	
	@Override
	public List<SmsStatistics> selectStatistics(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("SMS.selectStatistics",smsStatisticsBean);
	}
	
	@Override
	public List<Sms> selectDetailInfoList(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("SMS.selectDetailInfoList", smsStatisticsBean);
	}
	@Override
	public int selectDetailInfoCount(SmsStatistics smsStatisticsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SMS.selectDetailInfoCount", smsStatisticsBean);
	}
	@Override
	public SmsStatistics selectStatisticsUseGroupKey(String groupKey) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SMS.selectStatisticsUseGroupKey",groupKey);
	}
	
	
	@Override
	public List<String> selectNotEndedGroupKey() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("SMS.selectNotEndedGroupKey");
	}
	
	@Override
	public int updateStatisticsProgress(String groupKey) {
		// TODO Auto-generated method stub
		return getSqlSession().update("SMS.updateStatisticsProgress", groupKey);
	}
	
}
