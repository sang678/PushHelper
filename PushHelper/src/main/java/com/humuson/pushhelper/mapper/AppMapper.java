package com.humuson.pushhelper.mapper;

import com.humuson.pushhelper.bean.AppUser;


public interface AppMapper {
	
	public int newAppUser(AppUser appUserBean);
	public int updateSmsReceiveFlag(AppUser appUserBean);
	public String selectSmsReceiveFlag(String custId);
	
}
