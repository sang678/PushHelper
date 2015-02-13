package com.humuson.pushhelper.scheduler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.mapper.PushLocalDBMapper;
import com.humuson.pushhelper.mapper.SmsDBMapper;

public class SmsScheduler {
	
	@Autowired
	SmsDBMapper smsDBMapper;
	
	@Autowired
	PushLocalDBMapper pushLocalDBMapper;
	
	Logger logger =  org.apache.log4j.Logger.getLogger(SmsScheduler.class);
	
	String smsMsg = "[PushHelper]메시지 보관함을 확인해주세요";
	
	// PUSH발송 결과가 실패일때, SMS발송
	public void failPushResult() {
		List<Push> list = pushLocalDBMapper.selectFailInfo();
		for (Push rBean : list){
			if("".equals(rBean.getPush_msg()) || rBean.getPush_msg() == null   ){ //앱메시지 내용만 보냈을때
				Sms smsBean = new Sms(0, rBean.getCust_id(), rBean.getCust_id(), smsMsg, 4, rBean.getReq_uid(), "1");
				smsDBMapper.insertSMSSend(smsBean);
				pushLocalDBMapper.insertSMSRaw(smsBean);
			} else { //Push 메시지를 발송
				Sms smsBean = new Sms(0, rBean.getCust_id(), rBean.getCust_id(), rBean.getPush_msg(), 4, rBean.getReq_uid(), "1");
				smsDBMapper.insertSMSSend(smsBean);
				pushLocalDBMapper.insertSMSRaw(smsBean);
			}
			pushLocalDBMapper.updateSMSCheck(rBean);
		}
	}
	
	public void unCheckPushResult() {
		List<Push> list = pushLocalDBMapper.selectUnCheckInfo();
		for (Push rBean : list){
			if("".equals(rBean.getPush_msg()) || rBean.getPush_msg() == null   ){ //앱메시지만 보낼때
				Sms smsBean = new Sms(0, rBean.getCust_id(), rBean.getCust_id(), smsMsg, 4, rBean.getReq_uid(), "1");
				smsDBMapper.insertSMSSend(smsBean);
				pushLocalDBMapper.insertSMSRaw(smsBean);
			} else {
				Sms smsBean = new Sms(0, rBean.getCust_id(), rBean.getCust_id(), rBean.getPush_msg(), 4, rBean.getReq_uid(), "1");
				smsDBMapper.insertSMSSend(smsBean);
				pushLocalDBMapper.insertSMSRaw(smsBean);
			}
			pushLocalDBMapper.updateSMSCheck(rBean);
		}
	}
	
	public void updateSMSResult(){
		String tableName="test";
		int result = smsDBMapper.updateTargetting("tableName"); // 가져올 대상 선정 ( SMS DB )
		
		if(result == -1)
			logger.error("발송대상표식용 업데이트문 실패");
				
		
		List<Sms> log = smsDBMapper.smsSelectLog("tableName"); // 선정대상 가져오기 ( SMS DB )
		
		for(Sms smsBean : log){
			result = pushLocalDBMapper.updateSentResult(smsBean); // 결과 업데이트 ( Local DB 업데이트 )
			if(result == -1)
				logger.error("로그 데이터 업데이트문 실패");
		}
		
		result = smsDBMapper.updateEndTargetSelect(tableName); // 가져온 대상 표시 삭제 ( SMS_DB )
		
		if(result == -1)
			logger.error("발송대상표식용 업데이트문 실패");
	}
}
