package com.humuson.pushhelper.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.humuson.pushhelper.bean.Member;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.service.LoginService;
import com.humuson.pushhelper.service.PushHelperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("newAccount")
public class NewAccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(NewAccountController.class);
	
	@Autowired
	private PushHelperService pushhelperService;
	
	@Autowired
	private LoginService loginService;
	

	public String getSHA256(String str) { // 작동방식 Sha256PasswordEncoder 참조
		String SHA = "";
		try {
			
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			SHA = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
	
	@ResponseBody
	@RequestMapping("newAccount") // 에이젝스를 이용한 가입처리 -> 새창 강제종료 후 가입성공 메시지 출력
	public void newAccount(@RequestParam("cellphone") String cellphone,@RequestParam("id") String id,
			@RequestParam("name") String name,@RequestParam("pw1") String pw,@RequestParam("email") String email,
			HttpSession session, HttpServletResponse response)
	{
		
		loginService.newAccount(new Member(0, name, id, getSHA256(pw), cellphone, email, null));
		
		try {
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print("<script type='text/javascript'>alert('가입에 성공하셨습니다');window.close();</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@ResponseBody
	@RequestMapping("sendCertKey") // 인증키 발송 부분
	public void sendCertKey(@RequestParam("cellphone") String cellphone, HttpSession session, HttpServletResponse response)
	{
		logger.debug("======== 인증키 발송 시작");
		Random r = new Random();
		String certKey = (r.nextInt(9000)+1000)+"";
		logger.debug("인증키 : " + certKey);
		
		int result;
		Sms smsBean = new Sms(0, cellphone, "null", "Push Helper 인증번호는 ["+certKey+"] 입니다.",
				4, null, null, null, null, null, null);
		result = pushhelperService.smsSendConfirmMessage(smsBean);
		
		if(result == -1)
			logger.error("문자발송 실패 (인증번호부분)");
		else{
			session.setAttribute("certKey", certKey);
			session.setAttribute("cellphone", cellphone);
		}
		
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	@ResponseBody
	@RequestMapping("confirmCertKey")
	public void confirmCertKey(@RequestParam("confirmKey") String confirmKey, @RequestParam("cellphone") String cellphone, HttpSession session, HttpServletResponse response)
	{
		logger.debug("======== 인증키 확인");
		int result;  // result  1 : 정상   2 : confirmKey값이 틀림   3 : 발급받은 폰번호가 키검증 당시 달라짐 
	
		if( confirmKey.equals(session.getAttribute("certKey")) && cellphone.equals(session.getAttribute("cellphone")) )
			result = 1;
		else if(!confirmKey.equals(session.getAttribute("certKey")))
			result = 2;
		else
			result = 3;
		
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("checkId")
	public void checkId(@RequestParam("id") String id, HttpServletResponse response)
	{
		try {
			response.getWriter().print(loginService.checkId(id));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("logout")
	public void logout(HttpSession session, HttpServletResponse response)
	{
		session.invalidate();
		try {
			response.sendRedirect("/push/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("certKeyClear")
	@ResponseBody
	public void certKeyClear(HttpSession session)
	{
		session.removeAttribute("certKey");
	}
}
