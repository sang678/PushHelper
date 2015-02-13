<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Push Helper-Push발송</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 부트스트랩 -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="../resources/js/jquery-1.11.2.min.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="../resources/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="../resources/js/respond.min.js"></script>
<link href="../resources/css/push.css" rel="stylesheet" />
<script src="../resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="header/header.jsp" %>
		<h2 id="forms-example">Push 작성</h2>
		<form action="sendPush.do" id="sendPush" name="sendPush" method="POST" role="form" enctype="multipart/form-data">
		<input type="hidden" id="menuValue" name="menuValue" value="pm">
		<input type="hidden" id="custIdValue" name="custIdValue" value="">
		<input type="hidden" id="msgType" name="msgType" value="T">
		
		<div class="col-md-12 bs-example" style="float: left; margin-bottom: 20px; padding-bottom: 10px; ">
			
			<div class="col-md-6" style="padding-left: 0px; float: left">
      			<h3><b>수신 목록</b></h3>
            	 <select multiple class="form-control" name="custIdList" id="custIdList" size="10"></select>
          		 <button type="button" id="listReset"  class="btn btn-default" style="float: right; margin-top:5px; margin-left: 7px;">목록 초기화</button>
            	 <button type="button" id="selectDel"  class="btn btn-default" style="float: right; margin-top:5px; ">선택 삭제</button>
       		</div>
			
			
			<div class="col-md-6">
		 		<div class="row">
		   		<h3><b>수신자</b></h3> 
		   		<input type="text" id="custId" name="custId" class="form-control" placeholder="등록된 아이디를 입력해주세요." style="width: 70%"/>
              	<input type="button" id="custIdAdd" value="추가"  class="btn-info form-control" style="width: 20% ">
              	<br/><br/>
		 		
          		</div>
         	
         		<div class="row">
					<h3><b>파일 업로드 목록</b></h3>
						<input type="file" id="file" name="file" class="file_input"><br/> 
					 	<b>사용안내</b><br/>
						1. 문서 종류는 엑샐,CSV 파일만 가능합니다.<br>
						2. A열에만 입력해주세요.
				</div>	
			</div>
		</div>
		
		
		<div class="col-md-12 bs-example" style="float: left;  ">
		<h3><b>메세지 작성</b></h3>
		
		<button type="button" class="btn btn-info pm " value="pm">푸시팝업+앱 내 메시지</button>
		<button type="button" class="btn btn-info p" value="p">푸시팝업</button>
		<button type="button"  class="btn btn-info m" value="m">앱 내 메시지</button>
		<br>
		<br>
		<div class="bs-example bs-example-tabs col-md-12">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active popup"><a href="#pushpopup" data-toggle="tab">푸시팝업</a></li>
				<li class="appmsg"><a href="#appmsg" data-toggle="tab">앱 내 메시지</a></li>
			</ul>
	
			<div id="myTabContent" class="tab-content" >
				
				<!--푸시 팝업 부분  -->
				<div class="tab-pane fade in active" id="pushpopup" align="center">
					<div class="col-md-8" >
						<!--텍스트입력부분  -->
						<div class="box_body_status" style="float: left; margin-top: 3px;  margin-right: 10px;">
							<div class="push_status">
								<li><img src="../resources/img/app_icon_sm.png" alt="app_logo" /></li>
								<li>
									<div id="pushTitleAnd" class="app_tit" style="width:100;">푸시팝업 제목을 입력해주세요. &nbsp;</div>
									<div><span id="pushMsgAnd">푸시팝업 내용을 입력해주세요.</span></div>
								</li>
							</div>
						</div>
						<!--안드로이드 부분  -->
						<div class="box_body_phone" style= "float: left; margin-top: 3px;">
							<div style="background-color: #fff; margin: 45px; padding: 20px 10px 10px 10px; overflow: auto; text-align: left; font-size: 14px; font-weight: bold; border-radius: 5px;">
								<div id="pushPopupMsgAnd" style="min-height: 100px; max-height: 300px;">푸시팝업 내용을 입력해주세요.</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-5" >
					<br/>
						<!--텍스트부분  -->
						<table width="100%"  border="0" style="border: none;">
							<tr>
								<td>
									<div id="pushTitleBox">
										<div><b>텍스트 푸시</b></div>
										<input id="pushTitle" name="pushTitle" style="width: 370px;" placeholder="푸시팝업 제목을 입력해주세요" class="input mb5" type="text" value="" maxlength="20" />
										<textarea class="form-control" rows="4" id="pushText" name="pushText" style="width: 370px;" placeholder="푸시팝업 내용을 입력해주세요."></textarea>
									</div>
									<div class="byte_position" style="padding-right: 1px;">
										<span class="remaining"><span class="count">0</span>/<span class="maxcount">80</span>byte	
									</div>
									
									<label for="richCheck"><input type="checkbox" id="richCheck" size="20" value="" /><b>리치 푸시</b></label>
									<div id="richEditor" style="display:none;">
										<textarea id="pushHtml" name="pushHtml" style="width:100%;height:200px;"></textarea>
										<script type="text/javascript">
											//<![CDATA[
											   CKEDITOR.replace( 'pushHtml',{
											   enterMode:'3',
											   bodyId: "rich",
											   fullPage: true,
											   on:{
												   key: function (evt) {
													  $("#pushPopupMsgAnd").html(CKEDITOR.instances.pushHtml.getData());
												   }
											   }
											});
											//]]>
										</script>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				<!-- 앱내메시지 부분   -->
				
				<div class="tab-pane fade" id="appmsg">
					<div class="col-md-4" >
						<div id="pushEdiorText" style="">
							<textarea class="form-control" id="pushAppText" name="pushAppText" style="width: 370px; margin-top: 3px;" rows="20" cols="15" ></textarea>
						</div>
						<div id="richEditorApp" style="display:none">
							<textarea id="pushHtmlApp" name="pushHtmlApp" style="width:100%;height:200px;"></textarea>
							<script type="text/javascript">
								//<![CDATA[
								   CKEDITOR.replace( 'pushHtmlApp',{
								   enterMode:'3',
								   bodyId: "richApp",
								   fullPage: true,
								   on:{
									   key: function (evt) {
										  $("#pushAppMsgText").html(CKEDITOR.instances.pushHtmlApp.getData());
										  editorByte(CKEDITOR.instances.pushHtmlApp, appCount, appMaxcount)
									   }
								   }
								 });
								//]]>
							</script>
						</div>
					<div class="byte_position" style="padding-right: 1px; " >
						<span class="remainingApp"><span id="appCount" class="appCount">0</span>/<span class="appMaxcount" id="appMaxcount">3500</span>byte
					</div>
	
					</div>
					
					<div class="col-md-6" >
					<div id="pushAppMsg" class="box_body_phone" style="word-wrap: break-word; word-break: break-all; background-color: #fff; margin-top: 3px; overflow: auto; margin-left: 10px; left:10px;">
						<div id="pushAppMsgText" class="box_text" style="background-color: #fff; text-align: left; max-width: 310px; font-size: 14px; font-weight: bold; ">앱 내 메시지를 작성해주세요</div>
					</div>
					
					</div>
				</div>
				
				</div>
			</div>
			<input type="button" id="send" style="display:block; clear:both; width:90px; margin-left: 31px" class="btn btn-primary" value="전송" onclick="sendCheck()"/>
			<!-- <button style="display:block; clear:both; width:90px; margin-left: 15px" class="btn btn-primary" id="send" >전송</button> -->
	</div>
		</form>
	</div>
</body>
</html>

<script type="text/javascript">
	function editorByte(editorId, byteId, limit) {
		 var contentId = textId;
		 var content = editorId.getData();
		 var contentLength = content.length;
		 var viewId = byteId;
	
		 var limitByte = limit;
		 var i = 0;
		 var countByte = 0; 
		 var subcountByte = 0;
		 var letterCheck = ""; 
		 var limitContent = ""; 
		 for(i=0;i<contentLength;i++) {
		  letterCheck = content.charAt(i);
		  if(escape(letterCheck).length>4) {
		   countByte += 2; 
		  } else {
		     countByte++;
		  }
		  if(countByte <= limitByte) {
		     subcountByte = i+1;
		  }
		 }
		 if(countByte>limitByte) {
		  alert(limitByte+"byte까지 전송 가능합니다.");
		  limitContent = content.substring(0, subcountByte);
		  content = editorId.setData(limitContent);
		  viewId.text(limitByte+" / "+limitByte+" byte");
		 } else {
		  viewId.text(countByte+" / "+limitByte+" byte");
		 }
		 contentId.focus();
		}
	
	
	$("#richCheck").click(function(){
	    var chk = $(this).is(":checked");//.attr('checked');
	    if(chk){
	    	$("#richEditor").show();
	    	$("#richEditorApp").show();
	    	$("#pushEdiorText").hide();
	    	$("#msgType").val("H");
	    	/* $(".select_subject input").attr('checked', true); */
	    } else {
	    	$("#richEditor").hide();
	    	$("#richEditorApp").hide();
	    	$("#pushEdiorText").show();
	    	$("#msgType").val("T");
	    }
	});
	
	/* 푸시 팝업:제목,내용  내용 길면 ... , 입력시 안드로이드 화면에 동시입력  */
	$("#pushTitle").keyup(function() {
	    var keyed = $(this).val().replace(/\n/g, '<br/>');
	    $("#pushTitleAnd").html(keyed); 
	    $("#pushTitleAnd").html(($("#pushTitle").val().length>18) ? $("#pushTitle").val().substring(0,18)+".." : $("#pushTitle").val() );
	});
	
	$("#pushText").keyup(function() {
	    var keyed = $(this).val().replace(/\n/g, '<br/>');
	    $("#pushMsgAnd").html(keyed); 
	    $("#pushPopupMsgAnd").html(keyed); 
	    $("#pushMsgAnd").html(($("#pushText").val().length>18) ? $("#pushText").val().substring(0,18)+".." : $("#pushText").val() );
		checkByte("pushText");
	});
	
	$("#pushAppText").keyup(function() {
	     var keyed = $(this).val().replace(/\n/g, '<br/>');
	    $("#pushAppMsg").html(keyed);
	    checkByteApp("pushAppText");
	});
	
	$("#pushText").keyup(function() {
	     var keyed = $(this).val().replace(/\n/g, '<br/>');
	});

	//푸시팝업,앱내메시지,푸시팝업+앱내메시지 내용 보여주기
	$(function() {
		$(".pm").click(function() {
	      $(".popup").show();
	      $(".appmsg").show();
	      $("#myTab a:first").tab("show")
	    });
	    $(".p").click(function() {
	      $(".popup").show();
	      $(".appmsg").hide();
	      $("#myTab a:first").tab("show")
	    });
	    $(".m").click(function() {
	      $(".popup").hide();
	      $(".appmsg").show();
	      $("#myTab a:last").tab("show")
		});
	});
	

	/* 전송 버튼 누르면 빈내용있으면 경고창 띄우는것과, 단건발송 정보 넘기기 */
	function sendCheck() {
    var confirmCheck = confirm("전송 하시겠습니까?");
    
    if(confirmCheck){
	    file = $("#file").val();
	    if($("#custIdList option").size() == 0 && file == "") {
	      alert("수신자를 입력해주세요.");
	    }else if($("#pushTitle").val() == "" && $("#pushText").val() == "" && $("#pushAppText").val() == "" 
	        && $("#richApp").val() == "" && $("#rich").val() == "") {
	        alert("내용을 입력해주세요.")
	    }else {
	       // 수신목록리스트 목록 custIdValue 히든값에 저장
	       for(var i=0; i<$("#custIdList option").size(); i++){
	    	   if($("#custIdValue").val() == ""){
	    		   $("#custIdValue").val($("#custIdList option:eq("+i+")").val()); 
               } else{
                   $("#custIdValue").attr("value", ($("#custIdValue").val()+","+$("#custIdList option:eq("+i+")").val()));
               }
	       }
	       $("#send").attr("disabled",true); 
	       $("#sendPush").submit();
	       alert("전송이 완료 되었습니다.");
	    }
    }else{
		alert("전송이 취소 되었습니다.");
	}
   }
	
	// 파일업로드 확장자 비교 
	$("#file").change(function(){
		val = $(this).val().split("\\");
		fileName = val[val.length-1]; //마지막 화일명
		fileExtention = fileName.substring(fileName.length-4, fileName.length); //확장자빼오기
		if(fileExtention.toLowerCase() == '.xls' || fileExtention.toLowerCase() == '.csv'){//허용 확장자 비교
		   	return true;
		} else{
		   	alert("xls, csv 파일만 선택해 주세요.");
		   	return false;
		}
	});

	// 푸시팝업+앱내메시지, 푸시팝업, 앱내메시지 구분해서 hidden에 값저장  
	$(".btn").click(function() {
    $("#menuValue").attr("value", $(this).attr("value"));
	}); 

	// 추가 버튼 클릭
	$("#custIdAdd").click(function() {
	    var custId = $("#custId").val();  
	    var checkPhoneNumber=/^[0-9]*$/;
	  
	    if(custId.search(checkPhoneNumber) == -1 ){
	    	alert("등록 아이디를 확인해주세요.");
	    	return;
	    }
	    if(custId == "" ){
     	    alert("사용하실 수 없는 아이디입니다.")
	    	return;
	    }
	    for(var i=0; i<$("#custIdList option").size(); i++) {
	    	if($("#custIdList option:eq("+i+")").val() == custId){
	        	alert("중복된 아이디 입니다.");
	            return;
	        }
	    }
	    $("#custIdList").append("<option value="+custId+">"+custId+"</option>");
	    $("#custId").val("");
	});

	// 선택 삭제
	$("#selectDel").click(function() {
		var custIdList = document.getElementById("custIdList");
	 	// 선택부분만 
		var isSelected = [];
	 	for (var i = 0; i < custIdList.options.length; ++i) {
	  		isSelected[i] = custIdList.options[i].selected;
	 	}
	 	
	 	// 뒷부분부터 선택부분 지우기
	 	i = custIdList.options.length;
	 	while (i--) {
	  		if (isSelected[i]) {
		  		custIdList.remove(i);
	  		}
	 	}
	});


	// 목록 초기화
	$("#listReset").click(function() {
		$("#custIdList option").remove();
	});

	function checkByte(input) {
		$('.remaining').each(function() {
			// count정보 및 count 정보와 관련된 textarea/input 요소를 찾아내서 변수에 저장한다.
			var $maxcount = $('.maxcount', this);
			var $count = $('.count', this);
			var $input = $("#"+input);
			// .text()가 문자열을 반환하기에 이 문자를 숫자로 만들기 위해 1을 곱한다.
			var maximumByte = $maxcount.text() * 1;
			// update 함수는 keyup, paste, input 이벤트에서 호출한다.
			var update = function() {
				var before = $count.text() * 1;
				var str_len = $input.val().length;
				var cbyte = 0;
				var li_len = 0;
				for (var i = 0; i < str_len; i++) {
					var ls_one_char = $input.val().charAt(i);
					if (escape(ls_one_char).length > 4) {
						cbyte += 2; //한글이면 2를 더한다
					} else {
						cbyte++; //한글아니면 1을 더한다
					}
					if (cbyte <= maximumByte) {
						li_len = i + 1;
					}
				}
				// 사용자가 입력한 값이 제한 값을 초과하는지를 검사한다.
				if (parseInt(cbyte) > parseInt(maximumByte)) {
					alert('80Byte가 초과되었습니다.\r초과된 부분은 자동으로 삭제됩니다.');
					var str = $input.val();
					var str2 = $input.val().substr(0, li_len);
					$input.val(str2);
					var cbyte = 0;
					for (var i = 0; i < $input.val().length; i++) {
						var ls_one_char = $input.val().charAt(i);
						if (escape(ls_one_char).length > 4) {
							cbyte += 2; //한글이면 2를 더한다
						} else {
							cbyte++; //한글아니면 1을 다한다
						}
					}
				}
				$count.text(cbyte);
			};
			// input, keyup, paste 이벤트와 update 함수를 바인드한다
			$input.bind('input keyup keydown paste change', function() {
				setTimeout(update, 0);
			});
			update();
		});
	}
	
	function checkByteApp(input) {
		$('.remainingApp').each(function() {
			// count정보 및 count 정보와 관련된 textarea/input 요소를 찾아내서 변수에 저장한다.
			var $maxcount = $('.appMaxcount', this);
			var $count = $('.appCount', this);
			var $input = $("#"+input);
			// .text()가 문자열을 반환하기에 이 문자를 숫자로 만들기 위해 1을 곱한다.
			var maximumByte = $maxcount.text() * 1;
			// update 함수는 keyup, paste, input 이벤트에서 호출한다.
			var update = function() {
				var before = $count.text() * 1;
				var str_len = $input.val().length;
				var cbyte = 0;
				var li_len = 0;
				for (var i = 0; i < str_len; i++) {
					var ls_one_char = $input.val().charAt(i);
					if (escape(ls_one_char).length > 4) {
						cbyte += 2; //한글이면 2를 더한다
					} else {
						cbyte++; //한글아니면 1을 더한다
					}
					if (cbyte <= maximumByte) {
						li_len = i + 1;
					}
				}
				// 사용자가 입력한 값이 제한 값을 초과하는지를 검사한다.
				if (parseInt(cbyte) > parseInt(maximumByte)) {
					alert('3500Byte가 초과되었습니다.\r초과된 부분은 자동으로 삭제됩니다.');
					var str = $input.val();
					var str2 = $input.val().substr(0, li_len);
					$input.val(str2);
					var cbyte = 0;
					for (var i = 0; i < $input.val().length; i++) {
						var ls_one_char = $input.val().charAt(i);
						if (escape(ls_one_char).length > 4) {
							cbyte += 2; //한글이면 2를 더한다
						} else {
							cbyte++; //한글아니면 1을 다한다
						}
					}
				}
				$count.text(cbyte);
			};
			// input, keyup, paste 이벤트와 update 함수를 바인드한다
			$input.bind('input keyup keydown paste change', function() {
				setTimeout(update, 0);
			});
			update();
		});
	}
	
</script>

