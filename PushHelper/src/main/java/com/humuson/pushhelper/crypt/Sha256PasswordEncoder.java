package com.humuson.pushhelper.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;


public class Sha256PasswordEncoder extends PlaintextPasswordEncoder {
	
	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		// TODO Auto-generated method stub
		return super.isPasswordValid(encPass, getSHA256(rawPass), salt);
	}
	
	public String getSHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); // SHA-256 기업에 대한 다이제스트 획득
			sh.update(str.getBytes()); // 입력받은 문자를 통한 다이제스트 변화
			byte byteData[] = sh.digest(); // 다이제스트로 바뀐 값을 바이트 배열에 삽입
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < byteData.length; i++) { // 바이트 배열의 원소 값에 0xff 를 & 연산하고 0x100 을 더한 값을 밑수 16을 이용해 문자열을 리턴하여 문자열의 1번째(0번쨰부터시작)의 값을 가져와 스트링 버퍼에 추가적으로 붙임
				sb.append(Integer.toString( (byteData[i] & 0xff) + 0x100, 16).substring(1)); 
			}
			SHA = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

}
