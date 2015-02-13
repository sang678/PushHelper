package com.humuson.pushhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humuson.pushhelper.bean.AppUser;
import com.humuson.pushhelper.mapper.AppMapper;


@Service("AppService")
public class AppServiceImpl implements AppService{
	
	@Autowired
	private AppMapper appMapper;
			
	
	@Override
	public int newAppUser(AppUser appUserBean) {
		// TODO Auto-generated method stub
		return appMapper.newAppUser(appUserBean);
	}

	@Override
	public int updateSmsReceiveFlag(AppUser appUserBean) {
		// TODO Auto-generated method stub
		return appMapper.updateSmsReceiveFlag(appUserBean);
	}
	
	@Override
	public String selectSmsReceiveFlag(String custId) {
		// TODO Auto-generated method stub
		return appMapper.selectSmsReceiveFlag(custId);
	}

}
