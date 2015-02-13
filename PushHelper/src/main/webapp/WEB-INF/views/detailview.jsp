<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="../resources/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="../resources/js/respond.min.js"></script>
	<!-- main페이지용 css -->
	<link href="../resources/css/sendit.css" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Push Helper - 상세 내역</title>
</head>

<body>
	<div class="container">
		
		<div class=article-list style="text-align: center">
				<br>
					<h1>상세 결과</h1>
				<br>
				<div class="table-responsive ">
					<table class="table table-condensed" style="">
						<thead>
							<tr align="center" bgcolor="#757575" style="color: white">
								<td style="width: 10%"><b>수신자</b></td>
								<td style="width: 10%"><b>발송일시</b></td>
								<td style="width: 10%"><b>Push결과</b></td>
								<td style="width: 10%"><b>수신시간</b></td>
								<td style="width: 10%"><b>오픈시간</b></td>
								<td style="width: 10%"><b>클릭시간</b></td>
								<td style="width: 10%"><b>SMS결과</b></td>
								<td style="width: 10%"><b>발송일시</b></td>
								<td style="width: 10%"><b>수신일시</b></td>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="list" items="${detail}">
							<tr align="center">
								<td><c:out value="${list.custId}" /></td>
								<td><c:out value="${list.regDate}" /></td>
								<td><c:out value="${list.pushMessage}" /></td>
								<td><c:out value="${list.resultTime}" /></td>
								<td><c:out value="${list.readTime}" /></td>
								<td><c:out value="${list.clickTime}" /></td>
								<td><c:out value="${list.smsMessage}" /></td> 
								<td><c:out value="${list.sentDate}" /></td>
								<td><c:out value="${list.rsltDate}" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>

</html>

<script type="text/javascript" >

String.prototype.bytes = function() {
	var str = this;
	var l = 0;
	for (var i=0; i<str.length; i++) l += (str.charCodeAt(i) > 128) ? 2 : 1;
	return l;
}

$("#nowByte").html($("#sms_txt").val().bytes())


function pagingProcess(pageNo) //pageNo 0번 : <<   6번 : >>  그외 : 페이지에 해당하는 숫자
{
	
	lastPageNo =  $("#lastPageNo").val();
	var page;
	if(lastPageNo >=5){ 
		if(pageNo >=1 && pageNo <= 5){	// 페이지 목록에서 >> 와 << 가 아닌 숫자를 눌렀을 때
			page = $("#page"+pageNo).html()
		}else if(pageNo == 0){
			if($("#page1").html() == 1){
				page = 1
			}
			else{
				page = parseInt($("#page1").html())-parseInt(1)
				for(i=1; i<=5; i++)
					$("#page"+i).html(parseInt($("#page"+i).html())-parseInt(5))
					
				for(i=1; i<=6; i++){ // 여기 숨겨놨던거 다시 보여주기 위함
					$("#page"+i).removeClass("hide")
				}
			}
		}else if(pageNo == 6){
			if($("#page5").html() == lastPageNo){
				page = lastPageNo
			}else{
				page = parseInt($("#page5").html())+parseInt(1)
				for(i=1; i<=5; i++){
					$("#page"+i).html(parseInt($("#page"+i).html())+parseInt(5))
					
				}
				if($("#page5").html() > lastPageNo)
					for(i=lastPageNo%5+1; i<=6; i++){ // 여기 초과분 하이드 시킬려고 함
						$("#page"+i).addClass("hide")
					}
				else if($("#page5").html() == lastPageNo)
					$("#page6").addClass("hide")
			}
		}
	}else{
		if(pageNo == 0 )
			page = 1
		else if (pageNo == 6)
			page = lastPageNo
		else
			page = pageNo
		
	}

	
	
	 $.ajax({
			type:"POST",
			url:"showSmsDetailAjax.do",
			data:{"page":page, "group_key":$("#group_key").val(),"mode":0},
			success:function(data){
				$("#list").remove();
				$("#article2").prepend(data);
				for(i=1; i<=5; i++)
					$("#page"+i).parent().removeClass("active")
				
				if(page%5 == 0){
					$("#page5").parent().addClass("active")
				}else if ( page == 1){
					$("#page1").parent().addClass("active")
				}
				else{
					$("#page"+(page%5)).parent().addClass("active")
				}
				
			},
			 error :function(request, status, error) {
					alert("실패")
					if (request.status != '0') {
					alert("code : " + request.status + "\r\nmessage : "
							+ request.reponseText + "\r\nerror : " + error);
					}
				}
				
			});

}


</script>

