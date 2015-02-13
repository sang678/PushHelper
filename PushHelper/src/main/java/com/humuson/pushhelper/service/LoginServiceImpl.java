package com.humuson.pushhelper.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.humuson.pushhelper.bean.Member;
import com.humuson.pushhelper.mapper.MemberMapper;


@Service("LoginService")
public class LoginServiceImpl implements LoginService, UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;
			
	//Member
	@Override
	public List<Member> memberList() {
		// TODO Auto-generated method stubmemberVO
		return memberMapper.memberList();
	}
	@Override
	public Member login(String MemberId) {
		// TODO Auto-generated method stub
		return memberMapper.login(MemberId);
	}
	
	@Override// UserDetailsService 로 부터 Override
	public UserDetails loadUserByUsername(String username) //Spring Security의 로그인 처리용 메소드
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String memberPassword = memberMapper.getMemberPassword(username);
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails member = new User(username, memberMapper.getMemberPassword(username), roles);
		return member;
		
	}
	
	
	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		return memberMapper.checkId(id);
	}
	
	@Override
	public int newAccount(Member memberBean) {
		// TODO Auto-generated method stub
		return memberMapper.newAccount(memberBean);
	}

	

}
