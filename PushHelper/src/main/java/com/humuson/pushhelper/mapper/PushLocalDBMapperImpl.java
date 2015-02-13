package com.humuson.pushhelper.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.Sms;

public class PushLocalDBMapperImpl extends SqlSessionDaoSupport implements PushLocalDBMapper{
	
	
	@Override
	public List<Push> selectDetailResult(String reqUid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Push.selectDetailResult", reqUid);
	}

	@Override
	public Push selectTotalCnt(int seq) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("Push.selectTotalCnt", seq);
	}

	// resultPage 결과뿌려주기
	@Override
	public List<Push> selectListResult(int seq) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Push.selectListResult", seq);
	}

	@Override
	public int updateResultCnt(Push cntBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("Push.updateResultCnt", cntBean);
	}

	@Override
	public int updateSMSCheck(Push rBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("Push.updateSMSCheck", rBean);
	}

	@Override
	public int insertPushList(Push psBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("Push.insertPushList", psBean);
	}

	@Override
	public int insertPushRaw(Push psBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("Push.insertPushRaw", psBean);
	}

	@Override
	public int updateRawResult(Push pBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("Push.updateRawResult", pBean);
	}

	@Override
	public List<Push> selectFailInfo() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Push.selectFailInfo");
	}
	
	@Override
	public List<Push> selectUnCheckInfo() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Push.selectUnCheckInfo");
	}

	@Override
	public int insertSMSRaw(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("Push.insertSMSRaw", smsBean);
	}

	@Override
	public int updateSentResult(Sms smsBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("Push.updateSentResult", smsBean);
	}
	
}
