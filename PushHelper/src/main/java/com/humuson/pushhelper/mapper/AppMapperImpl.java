package com.humuson.pushhelper.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.AppUser;

public class AppMapperImpl extends SqlSessionDaoSupport implements AppMapper{

	@Override
	public int newAppUser(AppUser appUserBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("App.newAppUser",appUserBean);
	}
	
	@Override
	public int updateSmsReceiveFlag(AppUser appUserBean) {
		// TODO Auto-generated method stub
		return getSqlSession().update("App.updateSmsReceiveFlag", appUserBean);
	}
	
	@Override
	public String selectSmsReceiveFlag(String custId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("App.selectSmsReceiveFlag", custId);
	}
}
