package com.humuson.pushhelper.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.Push;

public class PushPmsDBMapperImpl extends SqlSessionDaoSupport implements PushPmsDBMapper{

	
	// push발송 성공,실패,클릭,오픈 cnt
	@Override
	public List<Push> selectListCnt(Long seq) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectListCnt", seq);
	}

	//Push 발송 
	@Override
	public int insertPushPms(Push psBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("Push.insertPushPms", psBean);
	}
	
	//Log 테이블 정보 가져오기
	@Override
	public List<Push> selectPmsLog() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Push.selectPmsLog");
	}

	//Log 가져온 정보 삭제
	@Override
	public void deletePmsLog(Long seq) {
		// TODO Auto-generated method stub
		getSqlSession().delete("Push.deletePmsLog", seq);
	}

	
	
	
	
}
