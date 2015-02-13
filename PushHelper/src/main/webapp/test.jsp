<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 부트스트랩 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="./resources/js/jquery-1.11.2.min.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="./resources/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="./resources/js/respond.min.js"></script>
<link href="./resources/css/push.css" rel="stylesheet" />
<script src="./resources/ckeditor/ckeditor.js"></script>
</head>
<body>

<div class="container">
	<form action="" method="post">
		<br>
			<h2>발송결과</h2>
		<br>
		
		<div class="table-responsive">
			<table class="table table-condensed" style="">
				<caption></caption>
				<colgroup align="center">
					<col width="30" />
					<col width="200" />
					<col width="120" />
					<col width="70" />
					<col width="40" />
					<col width="40" />
					<col width="40" />
					<col width="40" />
				</colgroup>
				<tbody>
					<tr align="center" bgcolor="#757575" style="color: white">
						<td scope="col"><b>NO</b></td>
						<td scope="col"><b>메시지</b></td>
						<td scope="col"><b>발송일시</b></td>
						<td scope="col"><b>총 발송수</b></td>
						<td scope="col"><b>성공</b></td>
						<td scope="col"><b>실패</b></td>
						<td scope="col"><b>오픈</b></td>
						<td scope="col"><b>클릭</b></td>
					</tr>
					
					<tr align="center">
					<td colspan="7">
						결과가 없습니다.
					</td> 
					</tr>
					<tr align="center">
						<%-- <td class="tal"><c:out value="${sr.seq}" /></td>
						<td class="tal"><c:out value="${sr.send_tel}" /></td>
						<td class="tal"><a href="${pageContext.request.contextPath}/listInfo.do?cmd=detailResult&seq=${sr.seq}&page=1"><c:out
									value="${sr.contents}" /></td>
						<td class="tal"><c:out value="${sr.send_date}" /></td>
						<td class="tal"><c:out value="${sr.total}" /></td>
						<td class="tal"><c:out value="${sr.success}" /></td>
						<td class="tal"><c:out value="${sr.fail}" /></td>
						<td class="tal"><c:out value="${sr.fail}" /></td> --%>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="bs-example">
			<ul class="pagination">
			
				<c:forEach var="p" begin="1" end="">
					
				</c:forEach>
				
			</ul>
		</div>
	</form>
</div>
</body>
</html>