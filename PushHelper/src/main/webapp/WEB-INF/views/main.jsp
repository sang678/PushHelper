<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
    <script src="../js/bootstrap.min.js"></script>
 
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="../resources/js/respond.min.js"></script>


	<!-- main페이지용 css -->
	<link href="../resources/css/sendit.css" rel="stylesheet" />

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Send it - 나의 발송내역</title>
	
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['성공',     <c:out value="${pageInfo.send_success}" />],
          ['실패',      <c:out value="${pageInfo.send_fail}" />]
        ]);

        var options = {
          title: '발송결과 통계'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart'));

        chart.draw(data, options);
      }
    </script>
	

</head>

<body>
	<div class="container">
		<%@ include file="header/header.jsp" %>
		<div id="section" style="margin:0 auto">
			<div id="article1">
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
				<div id="chart" class="">
				</div>
			</div>
			<br />
			
			<div id="article2">
				<div style="text-align:right;display:block" ><span class="btn btn-success" onClick="location.href='loadSendMessage.do';">발송하기</span></div><br id="useAppend" />
				
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
				
				<div id="list">
					<ul>
						<c:forEach var="bean" items="${listInfo}" varStatus="status"> 					<!-- forEach 문 시작  -->
							<c:set var="successAverage" value="${bean.success/bean.total}" />
							<c:set var="failAverage" value="${bean.fail/bean.total}" />
							<li class="data_list data_list_color${status.index % 2}"  >
								<span class="list_title"
									onClick="showDetail('<c:out value='${bean.req_uid}'/>')" >
								<c:out value="${bean.push_title}" /></span><br />
								<%-- <c:if test="${bean.st_progress == 0  || bean.st_progress == null}"><img class="pull-right" style="width:71px;height:71px;" src="../resources/img/progressCircle.gif"/></c:if><br> --%>
								<span class="list_time"><c:out value="${bean.reg_date}" /></span> <br />
								<span class="list_info">
									 총합 : <span class="list_sum">${bean.total}</span> 
									| 성공 : <span class="list_success">
													${bean.success }
													( 
														<c:choose>
															<c:when test="${successAverage =='NaN'}">0.0</c:when>
															<c:otherwise>${successAverage*100 }</c:otherwise>
														</c:choose>
													
													% )
											 </span> 
									| 실패 :  <span class="list_fail">${bean.fail } 
									
													( 
	
														<c:choose>
															<c:when test="${failAverage =='NaN'}">0</c:when>
															<c:otherwise>${failAverage*100 }</c:otherwise>
														</c:choose>
													
													% )

											  </span>
								</span>
							</li>
						</c:forEach>  					<!-- forEach 문 종료  -->
						<c:if test="${ fn:length(statisticsList) == 0 }"  >
							<li><h1>발송 내역이 없습니다.</h1></li>
						</c:if>
					</ul>	
				</div>
				<c:if test="${ fn:length(statisticsList) >=1 }"  >
					<fmt:parseNumber var="lastPage" integerOnly= "true" value="${(pageInfo.st_seq / 10) + (pageInfo.st_seq % 10 == 0 ? 0 : 1 ) } " />
					<input type="hidden" id="lastPageNo" value="<c:out value='${lastPage}' />" />
					<div id="paging" style="text-align:center">
						<ul class="pagination">
						  <li><a  id="page0" onClick="pagingProcess(0)">«</a></li>
							 <c:if test="${lastPage >= 1}">
							  	<li class="active"><a  id="page1" onClick="pagingProcess(1)">1</a></li>
							 </c:if>
							 <c:if test="${lastPage >= 2}">
							  	<li><a  id="page2" onClick="pagingProcess(2)">2</a></li>
							 </c:if>
							 <c:if test="${lastPage >= 3}">
							  	<li><a  id="page3" onClick="pagingProcess(3)">3</a></li>
							 </c:if>
							 <c:if test="${lastPage >= 4}">
							  	<li><a  id="page4" onClick="pagingProcess(4)">4</a></li>
							 </c:if>
						  	 <c:if test="${lastPage >= 5}">
							    <li><a  id="page5" onClick="pagingProcess(5)">5</a></li>
							 </c:if>
						  <li><a  id="page6" onClick="pagingProcess(6)">»</a></li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<form action="showSmsDetail.do" method="POST" id="f">
		<input type="hidden" id="group_key" name="group_key" />
		<input type="hidden" id="detail_success" name="detail_success" />
		<input type="hidden" id="detail_fail" name="detail_fail" />
		<input type="hidden" id="detail_txt" name="detail_txt" />
		<input type="hidden" id="call_from" name="call_from" />
	</form>
	
</body>

</html>


<script type="text/javascript">
$('#moveMain').remove()

function showDetail(group_key)
{

	$("#group_key").val(group_key);

	$("#f").submit();
	
}

function pagingProcess(pageNo)
{
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