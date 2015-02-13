package com.humuson.pushhelper.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.humuson.pushhelper.bean.Member;
import com.humuson.pushhelper.bean.Sms;

public interface LoginService {
	public List<Member> memberList() ;
	public Member login(String MemberId);
	public int newAccount(Member memberBean);
	public int checkId(String id);

}
