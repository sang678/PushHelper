package com.humuson.pushhelper.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.humuson.pushhelper.bean.Member;
import com.humuson.pushhelper.bean.Push;
import com.humuson.pushhelper.bean.SmsStatistics;
import com.humuson.pushhelper.mapper.PushLocalDBMapper;
import com.humuson.pushhelper.service.LoginService;
import com.humuson.pushhelper.service.PushHelperService;
import com.opencsv.CSVReader;

/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping("pushhelper")
public class PushHelperController {
	
	private static final Logger logger = LoggerFactory.getLogger(PushHelperController.class);
	private static final String savePath = "C:/uploadFile/";
	private static final String richPushJS = "<script src=\"http://pms.amail.co.kr/pms-sdk.js\"></script>";
	private static final String metaTag = "<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0.5\" name=\"viewpor\" />";

	@Autowired
	private PushHelperService pushhelperService;
	
	@Autowired
	private LoginService loginService;
	

	private void writeFile(MultipartFile multipartFile,String fileKey) {
		logger.debug("======== 파일쓰기 시작");
		logger.debug("파일명 : " +  multipartFile.getOriginalFilename());
        OutputStream out = null;
        try {

            out = new FileOutputStream(savePath + multipartFile.getOriginalFilename()+fileKey);
            BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
            byte[] buffer = new byte[8106];
            int read;
            while ((read = bis.read(buffer)) > 0) {
                out.write(buffer, 0, read);
            }

        } catch (IOException ioe) {
        	ioe.printStackTrace();
        	logger.error("파일쓰기에러");
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
	
	@RequestMapping("detailInfo")
	public ModelAndView detailInfo(HttpSession session,@RequestParam("reqUid") String reqUid) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("detail", pushhelperService.selectDetailResult(reqUid));
		mv.setViewName("detailview");
		
		return mv;
	}
	
	@RequestMapping("main") // 로그인 후 할일 설정  로그인한 멤버의 정보 세션 등록 및 전체리스트 출력
	public ModelAndView main(@RequestParam Map<String, Object> parmMap, ModelMap model, Principal principal,
			HttpSession session, HttpServletResponse response ) throws Throwable {
		
		ModelAndView mv = new ModelAndView();
		
		String id = principal.getName();
		
		Member loginUser = loginService.login(id);
		
		if(loginUser == null) {
			logger.error("로그인 성공 후 로그인 계정 데이터 가져오기 실패");
			response.sendRedirect("../login.jsp");
		}
		else {
			session.setAttribute("loginUser", loginUser);
			
			int mbSeq = ((Member)session.getAttribute("loginUser")).getMb_seq();
			
			mv.addObject("listInfo", pushhelperService.selectListResult(mbSeq));
			mv.addObject("cnt", pushhelperService.selectTotalCnt(mbSeq));
			
			
			
			//mv = showStatisticsList(loginUser.getMb_seq());
			/*SmsStatistics pageInfo = new SmsStatistics(0, null, 0, 0, loginUser.getMb_seq(), null, null, null,null) ;
			mv.addObject("statisticsList",pushhelperService.selectSmsStatistics(pageInfo));
			SmsStatistics temp = pushhelperService.selectResultSum(pageInfo);
			pageInfo.setSt_seq(temp.getSt_seq());
			pageInfo.setSend_success(temp.getSend_success());
			pageInfo.setSend_fail(temp.getSend_fail());
			mv.addObject("pageInfo",pageInfo);*/
		}

		mv.setViewName("main");
		
		return mv;
	}

	
	@RequestMapping("sendpush")
	public String sendPush(@RequestParam("pushTitle") String pushTitle, @RequestParam("pushText") String pushText, 
			@RequestParam("pushAppText") String pushAppText, @RequestParam("menuValue") String menuValue,
			@RequestParam("custIdValue") String custIdValue, @RequestParam("msgType") String msgType,
			@RequestParam("pushHtmlApp") String pushHtmlApp, @RequestParam("pushHtml") String pushHtml,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		logger.debug("======== 푸시 발송시작");
		
		Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //yyyy:년 MM: 월 dd: 일 HH: 시간(0~23) mm : 분 ss:초 SSS : 밀리세컨드 = 천분의 1초(0~999)
	    String uid = "pushhelper"+ dateFormat.format(calendar.getTime());
		logger.debug("uid : " + uid);
		int mbSeq = ((Member)session.getAttribute("loginUser")).getMb_seq();
		String fileKey = dateFormat.format(calendar.getTime());
		String bizId = "bed17c7c0b31478a87c7e371f2b14861";
		String msgGrpCd = "01011";
		String info = "-";
		Push listBean = null;
		Push pmsBean = null;
		Push rawBean = null;
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest)request; 
		List<MultipartFile> files = multipartRequest.getFiles("file");
		
		pushHtmlApp = metaTag + pushHtmlApp + richPushJS; 
		pushHtml = metaTag + pushHtml + richPushJS;
		
		if(msgType.equals("T")) {
			if(menuValue.equals("pm")){
				listBean = new Push(uid, msgType, pushTitle, pushText, pushAppText, mbSeq, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushTitle, pushText, pushAppText, info, info, msgGrpCd);
			}else if(menuValue.equals("p")){
				listBean = new Push(uid, msgType, pushTitle, pushText, mbSeq, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushTitle, pushText, info, info, msgGrpCd);
			}else if(menuValue.equals("m")){
				listBean = new Push(uid, msgType, pushAppText, mbSeq, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushAppText, info, info, msgGrpCd);
			}
		} else if(msgType.equals("H")){
			if(menuValue.equals("pm")){
				listBean = new Push(mbSeq, uid, msgType, pushTitle, pushText, pushHtml, pushHtmlApp, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushTitle, pushText, pushHtml, pushHtmlApp, info, info, msgGrpCd, null);
			}else if(menuValue.equals("p")){
				listBean = new Push(mbSeq, uid, msgType, pushTitle, pushText, pushHtml, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushTitle, pushText, pushHtml, info, info, msgGrpCd);
			}else if(menuValue.equals("m")){
				listBean = new Push(mbSeq, uid, msgType, pushHtmlApp, 0);
				pmsBean = new Push(bizId, uid, uid, null, msgType, pushHtmlApp, info, info, msgGrpCd);
			}
		}
		
		CSVReader reader; // 외부 라이브러리 CSV를 손쉽게 읽고 사용할 수 있도록 도와줌
		rawBean = new Push(uid, null);
		
		int totalCnt = 0;
		StringTokenizer st = new StringTokenizer(custIdValue, " ,");
		while (st.hasMoreElements()) {
			++totalCnt;
			String custId = st.nextToken();
			pmsBean.setCust_id(custId);
			rawBean.setCust_id(custId);
			pushhelperService.insertPushRaw(rawBean);
			pushhelperService.insertPushPms(pmsBean); 
		}
		
		try {
			for(MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				if("".equals(fileName))
					continue;
				writeFile(file,fileKey);
				//파일이름
				
				if(fileName.substring(fileName.length()-3).equals("xls")){
					Workbook workbook;
					workbook = Workbook.getWorkbook(new File(savePath + "/" + fileName));
					Sheet sheet = workbook.getSheet(0);
					int col = sheet.getColumns(); // 시트의 컬럼의 수를 반환한다.
					int row = sheet.getRows(); // 시트의 열의 수를 반환한다.

					ArrayList<String> list = new ArrayList<String>();
					
					
					for (int i = 0; i < row; i++) { // Record를 읽어 배열로 저장  ArrayIndexOutOfBoundsException을 막기위해.
						String receiver = sheet.getCell(0, i).getContents(); // 엑셀 번호 
						if("".equals(receiver))
							continue;
						String custId = receiver.replace("-", "");
						list.add(custId);
					}
				
					ArrayList<String> resultList = new ArrayList<String>(); // list 저장된 번호 중복제거
					HashSet<String> hs = new HashSet<String>(list);
					
					Iterator<String> it = hs.iterator(); 
					while (it.hasNext()) { // 중복이 제거된 번호를 출력
						String custId = it.next();
						++totalCnt;
						pmsBean.setCust_id(custId);
						pushhelperService.insertPushPms(pmsBean); 
						rawBean.setCust_id(custId);
						pushhelperService.insertPushRaw(rawBean);
					}
					
				} else if(fileName.substring(fileName.length()-3).equals("csv")){

					reader = new CSVReader(new FileReader(savePath+fileName+fileKey)); 
					
					List<String[]> data = reader.readAll();
					List<String[]> uniqueData = new ArrayList<String[]>(new HashSet<String[]>(data)); // 중복제거
					for(String[] sv : uniqueData)
					{
						if("".equals(sv[0]))
							continue;
						++totalCnt;
						//실제 push발송
						rawBean.setCust_id(sv[0]);
						pushhelperService.insertPushRaw(rawBean);
						pmsBean.setCust_id(sv[0]);
						pushhelperService.insertPushPms(pmsBean); 
					
					}
					
					reader.close();
					new File(savePath+fileName+fileKey).delete();
			
				}
			}// for문 끝
			
			listBean.setTotal(totalCnt);
			pushhelperService.insertPushList(listBean);  // 로컬DB push_list 값 삽입
//			int listSeq = listBean.getSeq();
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("파일 찾기 실패");
		}finally{
			// 
		}
		
		return "sendpush";
	}

	
	
	
	@RequestMapping("showStatisticsListAjax") // 전체리스트 페이징 처리를 위한 Ajax용 메소드
	public ModelAndView showStatisticsListAjax(HttpSession session, @RequestParam("page") int page)
	{
		ModelAndView mv = new ModelAndView();
		
		SmsStatistics pageInfo = new SmsStatistics(0, null, (page-1)*10, 0, 
				((Member)session.getAttribute("loginUser")).getMb_seq(), null, null, null,null) ;
		
		mv.addObject("statisticsList",pushhelperService.selectSmsStatistics(pageInfo));
		SmsStatistics temp = pushhelperService.selectResultSum(pageInfo);
		pageInfo.setSt_seq(temp.getSt_seq());
		pageInfo.setSend_success(temp.getSend_success());
		pageInfo.setSend_fail(temp.getSend_fail());
		mv.addObject("pageInfo",pageInfo);
		
		mv.setViewName("ajaxForStatisticsPage");
		
		return mv;
	}
	
	@RequestMapping("showStatisticsList") // 전체 리스트 출력 메소드
	public ModelAndView showStatisticsList(HttpSession session, @RequestParam("page") int page)
	{
		logger.debug("======== Statistics 리스트 조회 시작");
		ModelAndView mv = new ModelAndView();
		
		SmsStatistics pageInfo = 
				new SmsStatistics(0, null, (page-1)*10, 0, 
						((Member)session.getAttribute("loginUser")).getMb_seq(), null, null, null,null) ;
		
		mv.addObject("statisticsList",pushhelperService.selectSmsStatistics(pageInfo));
		SmsStatistics temp = pushhelperService.selectResultSum(pageInfo);
		pageInfo.setSt_seq(temp.getSt_seq());
		pageInfo.setSend_success(temp.getSend_success());
		pageInfo.setSend_fail(temp.getSend_fail());
		mv.addObject("pageInfo",pageInfo);
		
		mv.setViewName("main");
		
		return mv;
	}
	
	

	
	@RequestMapping("showSmsDetail") // 상세정보 리스트 출력
	public ModelAndView showSmsDetail(HttpSession session,@RequestParam("group_key") String groupKey)
	{
		logger.debug("======== 상세정보 리스트 조회 시작");
	
		ModelAndView mv = new ModelAndView();

		
		SmsStatistics detailPageInfo = pushhelperService.selectStatisticsUseGroupKey(groupKey); // 그룹키를 통한 상세정보 내역 조회
		
		detailPageInfo.setMb_seq(0); // Mb_seq : 페이징 처리를 위한 정보 - 페이지의 시작번호를 가진다
		mv.addObject("detailList", pushhelperService.selectDetailInfoList(detailPageInfo)); // 
		
		detailPageInfo.setSt_seq(pushhelperService.selectDetailInfoCount(detailPageInfo)); // 총 게시글 개수 조회
		mv.addObject("detailPageInfo", detailPageInfo);
		
		mv.setViewName("detail");
		
		return mv;
	}
	
	@RequestMapping("showSmsDetailAjax")
	public ModelAndView showSmsDetailAjax(
			@RequestParam("group_key") String group_key, @RequestParam("page") int page,
			@RequestParam("mode") int mode)
	{
		ModelAndView mv = new ModelAndView();
		
		 // 모드가 1이면 성공값만 2면 실패값만 3이면 대기값만 /// 성공 = 1 실패 = 2 대기 = 3
		 // 추가 기능용 설정 ( 모드에 따라 성공 실패 대기 각각 해당 정보 출력을 계획함
		
		SmsStatistics detailPageInfo = new SmsStatistics(mode, null, 0, 0, (page-1)*10, group_key, null, null,null);
		
		mv.addObject("detailList", pushhelperService.selectDetailInfoList(detailPageInfo));
		detailPageInfo.setSt_seq(pushhelperService.selectDetailInfoCount(detailPageInfo));
		mv.addObject("detailPageInfo", detailPageInfo);
		mv.setViewName("ajaxForSmsResultPage");
		
		
		return mv;
	}
	
	@RequestMapping("loadSendMessage")
	public ModelAndView loadSendMessage() { 
		return new ModelAndView("sendMessage");
	}
	
	@RequestMapping("writePush")
	public ModelAndView writePush() {
		return new ModelAndView("sendpush");
	}
	
	
}
