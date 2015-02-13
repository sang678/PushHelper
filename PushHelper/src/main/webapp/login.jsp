<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="./resources/js/jquery-1.11.2.min.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="./resources/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="./resources/js/respond.min.js"></script>
<style type="text/css">
 html, body {
    height: 100%;
}
</style> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Push Helper</title>
</head>
<body style="background-color:#EFF0F1; ">
	<div class="container" style="text-align:center; vertical-align:middle; height:100%; ">
		<div style="display:table; width:100%; height:100%;" >
			<div style="display:table-cell;vertical-align:middle;" >
				<div style="width:290px; height:385px; display:inline-block; text-align:center; background-color:#FFFFFF; border-right:3px solid #777777; border-bottom:3px solid #777777;">
					<div style="text-align:right; color:#999"><span id="newAccount" style="padding-right:10px; cursor:pointer">회원가입</span></div>
					<div style="width:230px; margin:auto; padding:30px 30px; padding-top:15px;">
						<h1>Push Helper</h1><br />
						<form action="j_spring_security_check" method="POST" >
							<input type="id" id="id" class="form-control" name="j_username" placeholder="아이디" />
							<br />
							<input type="password" id="pw" class="form-control" name="j_password" placeholder="비밀번호" />
							<br />
							<button style="width:100%; height:50px;" class="btn btn-success">로그인</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>


<script type="text/javascript">		
<%if(request.getParameter("fail") != null){%>
	alert("로그인실패")
<%}else if(request.getParameter("duplicate") != null){%>
	alert("동일한 아이디로 접속이 감지되어 연결이 중지되었습니다.")
<%}%>
$("#newAccount").click(function(){
	var win = window.open("http://localhost:8080/pushhelper/newAccount.jsp","Push Helper 회원가입","width=480px,height=800px,resizeable=no,scrollbars=yes")
		if(win.focus)
			win.focus();
});
</script>
