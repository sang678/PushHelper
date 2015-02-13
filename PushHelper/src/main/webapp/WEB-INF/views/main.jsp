<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="../resources/js/jquery-1.11.2.min.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="../resources/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="../resources/js/respond.min.js"></script>
	<!-- main페이지용 css -->
	<link href="../resources/css/sendit.css" rel="stylesheet" />
	<link href="../resources/css/push.css" rel="stylesheet" />

	<title>Push Helper - 나의 발송내역</title>
	<!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          /* ['성공',     <c:out value="${pageInfo.send_success}" />],
          ['실패',      <c:out value="${pageInfo.send_fail}" />] */
        ]);

        var options = {
          title: '발송결과 통계'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart'));

        chart.draw(data, options);
      }
    </script> -->
</head>
<body>
	<div class="container">
		<%@ include file="header/header.jsp" %>
		<div id="section" style="margin:0 auto">
			<div id="article1">
			<form action="detailInfo.do" method="POST" id="di">
				<input type="hidden" id="reqUid" name="reqUid">
			</form>
			
				<span class="btn btn-success" onClick="location.href='writePush.do';">Push 발송</span>
				
				<h1>총 발송 내역</h1><br/>
				<table class="table table-responsive" style="font-size:14px;">
					<thead>
						<tr style="font-weight : bold">
							<td>총발송량</td><td>성공</td><td>실패</td><td>오픈</td><td>클릭</td>
						</tr> 
					</thead>
					<tbody>
						<tr style="border-bottom:1px solid #DDD">
							<td><c:out value="${cnt.total}" /></td>
							<td><c:out value="${cnt.success}" /></td>
							<td><c:out value="${cnt.fail}" /></td>
							<td><c:out value="${cnt.read}" /></td>
							<td><c:out value="${cnt.click}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
				
			<div id="chart" class="">
					
			</div>
			
			
			<div class=article-list style="text-align: center">
				<br>
					<h1>발송 결과</h1>
				<br>
				<div class="table-responsive ">
					<table class="table table-condensed">
						<thead>
							<tr align="center" bgcolor="#757575" style="color: white">
								<td style="width: 20%"><b>발송일시</b></td>
								<td style="width: 45%"><b>메시지</b></td>
								<td style="width: 10%"><b>총 발송수</b></td>
								<td style="width: 5%"><b>성공</b></td>
								<td style="width: 5%"><b>실패</b></td>
								<td style="width: 5%"><b>오픈</b></td>
								<td style="width: 5%"><b>클릭</b></td>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="list" items="${listInfo}">
							<tr align="center">
								<td class="tal"><c:out value="${list.reg_date}" /></td>
								<td class="listResult" onclick="detailPageInfo('<c:out value='${list.req_uid}'/>')"><c:out value="${list.push_title}" /></td>
								<td class="tal"><c:out value="${list.total}" /></td>
								<td class="tal"><c:out value="${list.success}" /></td>
								<td class="tal"><c:out value="${list.fail}" /></td>
								<td class="tal"><c:out value="${list.read}" /></td>
								<td class="tal"><c:out value="${list.click}" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>  <!--container  -->
	
</body>
</html>


<script type="text/javascript">
$('#moveMain').remove()

function detailPageInfo(reqUid){

	$("#reqUid").val(reqUid);
	$("#di").submit();
	
}

function pagingProcess(pageNo) {
	lastPageNo =  $("#lastPageNo").val();
	
	var page;
	
	if(lastPageNo >=5){
		if(pageNo >=1 && pageNo <= 5){  // 페이지 목록에서 >> 와 << 가 아닌 숫자를 눌렀을 때
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
				alert(page)
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
			url:"showStatisticsListAjax.do",
			data:{"page":page},
			success:function(data){
				$("#list").remove();
				$("#useAppend").after(data);
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
					alert("페이지 전환 실패")
					if (request.status != '0') {
					alert("code : " + request.status + "\r\nmessage : "
							+ request.reponseText + "\r\nerror : " + error);
					}
				}
				
			});

}


</script>