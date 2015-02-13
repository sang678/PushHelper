package com.humuson.pushhelper.mapper;

import java.util.List;

import com.humuson.pushhelper.bean.Member;

public interface MemberMapper {
	public List<Member> memberList();
	public Member login(String memberId);
	public String getMemberPassword(String memberId);
	public int newAccount(Member memberBean);
	public int checkId(String id);
}
