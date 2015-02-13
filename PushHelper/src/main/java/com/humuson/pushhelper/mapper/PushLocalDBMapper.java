package com.humuson.pushhelper.mapper;

import java.util.List;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;


public interface PushLocalDBMapper {
	
	public int insertPushList(Push psBean);
	public int insertPushRaw(Push psBean);
	public int updateRawResult(Push pBean);
	public List<Push> selectFailInfo();
	public int updateSMSCheck(Push rBean);
	public int updateResultCnt(Push cntBean);
	public List<Push> selectUnCheckInfo();
	public int insertSMSRaw(Sms smsBean);
	public int updateSentResult(Sms smsBean);
	public List<Push> selectListResult(int seq);
	public Push selectTotalCnt(int seq);
	public List<Push> selectDetailResult(String reqUid);
	
}
