package com.humuson.pushhelper.mapper;

import java.util.List;

import com.humuson.pushhelper.bean.Push;

public interface PushPmsDBMapper {
	
	public int insertPushPms(Push psBean);
	
	public List<Push> selectPmsLog();
	
	public void deletePmsLog(Long seq);
	
	public List<Push> selectListCnt(Long seq);
	
}
