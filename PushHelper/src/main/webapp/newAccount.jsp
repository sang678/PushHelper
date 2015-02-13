<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8" />	
	<title>Push Helper 회원가입</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- JQuery Validate (유효성검증용) -->
    <script src="./resources/js/jquery.validate.min.js"></script> 
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="./resources/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="./resources/js/respond.min.js"></script>
    <!-- 페이지 디자인용 CSS -->
    <link href="./resources/css/sendit.css" rel="stylesheet" />
    
</head>

<body>
	<br />
	<div id="container" class="container">
		<form action="newAccount/newAccount.do" method="post" role="form" id="sign">
			<div class="row">
				<div class="form-group">
					<div class="col-xs-6 col-lg-3">
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" class="form-control" placeholder="아이디" />
					</div>
					<div class="btn btn-default col-xs-3 col-lg-2" style="margin-top:25px;" onClick="checkId()">
						중복확인
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<dvi class="form-group">
					<div class="col-xs-6 col-lg-3">
						<label for="name">이름</label>
						<input type="text" id="name" name="name" class="form-control" placeholder="이름" />
					</div>
				</dvi>
			</div>
			<br />	
			<div class="row">
				<div class="form-group">
					<div class="col-xs-6 col-lg-3">
						<label for="pw1">비밀번호</label>
						<input type="password" id="pw1" name="pw1" class="form-control" placeholder="비밀번호"/>
					</div>
					<div class="col-xs-6 col-lg-3" >
						<label for="pw2">비밀번호 확인</label>
						<input type="password" id="pw2" name="pw2" class="form-control" placeholder="비밀번호 확인"/>
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="form-group">
					<div class="col-xs-12 col-lg-6">
						<label for="email">이메일</label>
						<input type="email" id="email" name="email" class="form-control" placeholder="account@domain.com"/>
					</div>
				</div>
			</div>
			<br />
			<div class="row" style="margin-left:0px">
			<label>휴대폰 및 인증요청</label><br />
			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="cellphone4">
				선택<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" id="dropdown">
					<li><a onClick="$('#cellphone4').html('010');$('#cellphone1').val('010')">010</a></li>
					<li><a onClick="$('#cellphone4').html('011');$('#cellphone1').val('011')">011</a></li>
					<li><a onClick="$('#cellphone4').html('016');$('#cellphone1').val('016')">016</a></li>
					<li><a onClick="$('#cellphone4').html('017');$('#cellphone1').val('017')">017</a></li>
					<li><a onClick="$('#cellphone4').html('019');$('#cellphone1').val('019')">019</a></li>
				</ul>
				<div class="col-xs-3 col-lg-4" style="padding-right:3px;">
					<input type="text" class="form-control" id="cellphone2" name="cellphone2" placeholder="중간자리">
				</div>
				<div class="col-xs-3 col-lg-4" style="padding-left:3px;">
					<input type="text" class="form-control" id="cellphone3" name="cellphone3" placeholder="뒷자리">
				</div>
				<div  id="request" class="btn btn-default col-xs-3 col-lg-2" onClick="requestCertKey()">
					인증요청
				</div>
				<br /><br />
				<div id="time" class="hide" >
					인증키 유효시간이 <span id="remainTime" style="color:red"><span id="minute" > </span>분 <span id="second" ></span>초</span> 남았습니다.
				</div>
			</div>
		</div>
		<br />
		<input type="hidden" id="cellphone1" name="cellphone1" value="" />
				<input type="hidden" id="cellphone" name="cellphone" value="" />
		<div id="cert" class="row">
			<div class="form-group">
				<div class="col-xs-8 col-lg-3">
					<label>인증받기</label>
					<input type="text" id="confirmKey" name="confirmKey" class="form-control"/>
				</div>
				<div class="btn btn-default" style="margin-top:25px" onClick="confirmCertKey()">
					인증확인
				</div>
			</div>
		</div>
		
		<br /><br />
		<div class="row">
			<div class="form-group col-xs-12 col-lg-6" style="text-align:center">
				<button class="btn btn-success">가입하기</button>
				<div class="btn btn-danger" style="margin-left:50px;" onClick="window.close()" >취소하기</div>
			</div>
		</div>
		<input type="hidden" id="canuseid" value="0" />
		<input type="hidden" id="isCert" value="0" />
		</form>
	</div>
</body>

</html>

<script type="text/javascript">

$.ajax({
	type:"POST",
	url:"newAccount/certKeyClear.do",
	
	});
$('#test').click(function(){
    //Some code 
    alert("test")
    
});	


var t;
var sec = 60 * 3;
function timer()
{
    minute = parseInt(sec / 60);
    second = sec - (minute*60);
    
    $("#minute").html(minute)
    $("#second").html(second)
    
    sec--;
	
	
	if(sec < 0){
		sec = 60 * 3;
		alert("인증키 만료! 다시 인증을 진행해주세요")
		
		clearInterval(t)
// 		var dropdown = "<ul class='dropdown-menu' role='menu' id='dropdown'>"
// 		dropdown += "<li><a onClick='$(\'#cellphone4\').html(\'010\');$(\'#cellphone1\').val(\'010\')'>010</a></li>"
// 		dropdown += "<li><a onClick='$(\'#cellphone4\').html(\'011\');$(\'#cellphone1\').val(\'011\')'>010</a></li>"
// 		dropdown += "<li><a onClick='$(\'#cellphone4\').html(\'016\');$(\'#cellphone1\').val(\'016\')'>010</a></li>"
// 		dropdown += "<li><a onClick='$(\'#cellphone4\').html(\'017\');$(\'#cellphone1\').val(\'017\')'>010</a></li>"
// 		dropdown += "<li><a onClick='$(\'#cellphone4\').html(\'019\');$(\'#cellphone1\').val(\'019\')'>010</a></li></ul>"
// 		$("#cellphone4").after(dropdown)
		
// 		$("input[name=cellphone2]").removeAttr("disabled")
// 		$("input[name=cellphone3]").removeAttr("disabled")
		
		$.ajax({
			type:"POST",
			url:"newAccount/certKeyClear.do",
			
			});
		
	}
}

function checkId()
{
	var id = $("#id").val()
	var checker = /^[a-zA-Z0-9]{3,20}?$/;
	if( checker.test(id)){
	 $.ajax({
		type:"POST",
		url:"newAccount/checkId.do",
		data:{
			"id":id
			},
		success:function(data){ // 리턴값은 현재 입력아이디가 DB에 들어있는 개수 - 즉 1이상이면 중복 
			if(data>=1)
			{
				alert("중복 확인이 제대로 이루어 지지 않았습니다.");
				$("#id").val("")
				$("#canuseid").val("0")
			}
			else{
				alert("사용 가능합니다.")
				$("#canuseid").val("1")
				$("#id").attr("disabled","true")
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
	else{
		alert("아이디는 최소 3자 최대 20자 영문 및 숫자로 입력해주세요")
	}
		
}


function requestCertKey()
{
	var cellphone1 = $("#cellphone1").val();
	var cellphone2 = $("#cellphone2").val();
	var cellphone3 = $("#cellphone3").val();
	var num = /^[0-9]{3,4}$/;
	
	
	if( !num.test(cellphone1) )
		alert("숫자를 선택해주세요")
	else if(!num.test(cellphone2))
		alert("숫자를 3~4개 입력해주세요");
	else if(!/^[0-9]{4}$/.test(cellphone3))
		alert("숫자를 4개입력해주세요")
	else{
		 $.ajax({
				type:"POST",
				url:"newAccount/sendCertKey.do",
				data:{"cellphone":cellphone1+cellphone2+cellphone3},
				success:function(data){
					if(data==-1)
						alert("발송서버 오류 - 재시도 하거나 나중에 시도하세요");
					else
						alert("발송성공 - 잠시만 기다려주세요")
					
					$("#time").removeClass("hide")
					sec = 60 * 3
					clearInterval(t)
					t = setInterval(timer, 1000);
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
	
	
		  
}

function confirmCertKey()
{
	var cellphone1 = $("#cellphone1").val();
	var cellphone2 = $("#cellphone2").val();
	var cellphone3 = $("#cellphone3").val();
	if($("#confirmKey").val() != "")
	 $.ajax({
		type:"POST",
		url:"newAccount/confirmCertKey.do",
		data:{
			"cellphone":cellphone1+cellphone2+cellphone3,
			"confirmKey":$("#confirmKey").val()
			},
		success:function(data){ // result  1 : 정상   2 : confirmKey값이 틀림   3 : 발급받은 폰번호가 키검증 당시 달라짐 
			if(data==1)
			{
				alert("인증에 성공하였습니다.");
				$("#request").remove();
				$("#time").remove();
				$("#cert").remove();
				clearInterval(t)
				$("#dropdown").remove();
				$("input[name=cellphone2]").attr("disabled","true")
				$("input[name=cellphone3]").attr("disabled","true")
				$("#isCert").val(1)
				
			}
			else if(data == 2 ){
				alert("인증번호가 다릅니다.");
				$("#isCert").val(0)
			}
				
			else{
				alert("인증번호를 받은 핸드폰번호와 현재 입력된 번호가 다릅니다.")
				$("#isCert").val(0)
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
	else{
		alert("인증번호를 입력후 확인버튼을 눌려주세요")
	}
		  
}


	jQuery.validator.addMethod("alphaNumeric", function(value, element) {

		return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);

	});

	jQuery.validator.addMethod("customEmail", function(value, element) {

		return this.optional(element) || /^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/g.test(value);

	});

	$('#sign').validate({    
        rules: {
            id: { required: true, minlength: 3, maxlength:20, alphaNumeric:true },
            pw1: { required: true, minlength: 3, maxlength:20 },
            pw2: { equalTo: "#pw1", minlength: 3, maxlength:20 },
            email: { required: true, customEmail:true, email:true, maxlength:30 },
            name: { required: true, minlength:2, maxlength:12 }
        },
        messages: {
            id: {
                required: $.validator.format("<span class='validateText'>아이디를 입력하세요.</span>"),
                minlength: $.validator.format("<span class='validateText'>아이디는 {0}자 이상입니다.</span>"),
                maxlength: $.validator.format("<span class='validateText'>아이디는 {0}자 이하입니다.</span>"),
                alphaNumeric:  $.validator.format("<span class='validateText'>아이디는 영문 또는 숫자입니다.</span>")
            },
            pw1: {
            	required:$.validator.format("<span class='validateText'>비밀번호를  입력하세요.</span>"),
            	minlength: $.validator.format("<span class='validateText'>비밀번호는 {0}자 이상입니다.</span>"),
                maxlength: $.validator.format("<span class='validateText'>비밀번호는 {0}자 이하입니다.</span>"),
            	alphaNumeric: $.validator.format("<span class='validateText'>비밀번호는 영문 또는 숫자입니다.</span>")
            },
            pw2: {
            	required:$.validator.format("<span class='validateText'>비밀번호 확인을 입력하세요.</span>"),
            	alphaNumeric: $.validator.format("<span class='validateText'>비밀번호는 영문 또는 숫자입니다.</span>"),
            	minlength: $.validator.format("<span class='validateText'>비밀번호는 {0}자 이상입니다.</span>"),
                maxlength: $.validator.format("<span class='validateText'>비밀번호는 {0}자 이하입니다.</span>"),
            	equalTo:$.validator.format("<span class='validateText''>비밀번호가 서로 다릅니다.</span>")
           	},
           	email: {
            	required: $.validator.format("<span class='validateText'>이메일 주소를 입력하세요</span>"),
            	email: $.validator.format("<span class='validateText'>올바른 이메일 주소를 입력하세요.</span>"),
            	customEmail: $.validator.format("<span class='validateText'>올바른 이메일 주소를 입력하세요.</span>")

            },
            name: {
            	required: $.validator.format("<span class='validateText'>이름을 입력하세요.</span>"),
            	minlength: $.validator.format("<span class='validateText''>이름은 {0}자 이상입니다.</span>"),
                maxlength: $.validator.format("<span class='validateText'>이름은 {0}자 이하입니다.</span>")	
            }
            
        },
        submitHandler: function (frm) {
        
        	if($("#canuseid").val() != 1)
        		alert("중복되는 아이디입니다 다시 확인해주세요")
        	else if($("#isCert").val() !=1 )
        		alert("휴대폰 인증을 진행해주세요")
        	else{
        		$("#cellphone").val($("#cellphone1").val()+$("#cellphone2").val()+$("#cellphone3").val())
        		$("#id").removeAttr("disabled")
            	frm.submit();
        	}
            
        },
        success: function (e) {
        //
        
        }
    });


</script>