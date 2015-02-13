package com.humuson.pushhelper.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.humuson.pushhelper.bean.Member;

public class MemberMapperImpl extends SqlSessionDaoSupport implements MemberMapper{
	
	@Override
	public List<Member> memberList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("Member.memberList");
	}
	
	@Override
	public Member login(String memberId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("Member.login",memberId);
	}
	
	@Override
	public String getMemberPassword(String memberId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("Member.getMemberPassword", memberId);
	}
	@Override
	public int newAccount(Member memberBean) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("Member.newAccount", memberBean);
	}
	
	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("Member.checkId",id);
	}
	
	
}
