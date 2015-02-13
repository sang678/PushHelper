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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.humuson.pushhelper.bean.AppUser;
import com.humuson.pushhelper.bean.Member;
import com.humuson.pushhelper.bean.Sms;
import com.humuson.pushhelper.service.AppService;
import com.humuson.pushhelper.service.LoginService;
import com.humuson.pushhelper.service.PushHelperService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("App")
public class AppController {
	
	
	@Autowired
	private AppService appService;
	
	/**
	
	* <pre>
	
	* 1. 메소드명 : appUserInfoInsertChange
	
	* 2. 작성일 : 2015. 2. 12. 오후 9:12:43
	
	* 3. 작성자 : humuson-사원-엄상근
	
	* 4. 설명 :Android App 으로부터 cust_id와 flag를 받아와 cust_id를 Table에 추가하거나 SMS 수신여부를 업데이트 한다.
	
	* </pre>
	
	* @param custId
	* @param flag : 1 = Insert  2 : SMS 수신   3 :  SMS 수신거부  4 : SMS 수신여부 조회 
	* @return
	
	*/
	@ResponseBody
	@RequestMapping("appUserInfoInsertChange") 
	public String appUserInfoInsertChange(@RequestParam("cust_id") String custId, @RequestParam("flag") String flag)
	{
		if(flag.equals("1")){
			return ""+appService.newAppUser(new AppUser(custId,flag));
		}
		else if(flag.equals("4")){
			return appService.selectSmsReceiveFlag(custId);
		}
		else{
			return ""+appService.updateSmsReceiveFlag(new AppUser(custId,flag));
		}
	}
	
}
