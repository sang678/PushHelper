package com.humuson.pushhelper.scheduler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.mapper.PushLocalDBMapper;
import com.humuson.pushhelper.mapper.PushPmsDBMapper;
import com.humuson.pushhelper.mapper.SmsDBMapper;
import com.humuson.pushhelper.mapper.SmsInsideDBMapper;

public class PushScheduler{
	
	
	@Autowired
	SmsInsideDBMapper smsInsideDBDao;
	@Autowired
	SmsDBMapper smsDBMapper;
	
	@Autowired
	PushLocalDBMapper pushLocalDBMapper;
	
	@Autowired
	PushPmsDBMapper pushPmsDBMapper;
	
	Logger logger =  org.apache.log4j.Logger.getLogger(PushScheduler.class);
	
	String smsMsg = "[PushHelper]메시지 보관함을 확인해주세요";
	
	//PUSH 발송결과 업데이트 부분
	public void updatePushResult() {
		List<Push> logList = pushPmsDBMapper.selectPmsLog(); //PMS SEND_QUE_LOG 테이블 정보 가져오기
		if(logList.size() != 0) {
			long seq = logList.get(0).getSeq();
			List<Push> resultCnt = pushPmsDBMapper.selectListCnt(seq); // s,f,r,c 카운트 숫자 가져오기
			for(Push cntBean : resultCnt){
				pushLocalDBMapper.updateResultCnt(cntBean);
			}
			
			for (Push pBean : logList) {
				pushLocalDBMapper.updateRawResult(pBean);
			}
			pushPmsDBMapper.deletePmsLog(seq); // Log에서 가져온 정보 삭제
		}
	}

}
