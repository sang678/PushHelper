package com.humuson.pushhelper.service;

import com.humuson.pushhelper.bean.AppUser;


public interface AppService {

	public int newAppUser(AppUser appUserBean);
	public int updateSmsReceiveFlag(AppUser ppUserBean);
	public String selectSmsReceiveFlag(String custId);

}
