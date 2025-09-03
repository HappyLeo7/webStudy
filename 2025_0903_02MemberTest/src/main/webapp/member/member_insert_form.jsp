<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 주소찾기 API 라이브러리 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
#box {
	width: 700px;
	margin: auto;
	margin-top: 100px;
}
.common{
margin : 10px;
padding : 10px;
border: 1px solid #cccccc;
}
label{
	width : 80px;
	
}
</style>
<script type="text/javascript">
	function check_id(){
		let mem_id=$("#mem_id").val();
		
		//회원가입 버튼을 비활성화
		$("#btn_register").prop("disabled",true);
		
		
		if(mem_id.length<3){
			$("#msg_id").html("id는 3글자 이상 지정해야합니다.").css("color","red")
			return;
		}
		
		$("#msg_id").html("");

		//서버에 아이디 체크 요청
	$.ajax({
		
		url : "check_id.do" //MemberCheckIdAction
		,data : {"mem_id":mem_id} //check_id.do?mem_id=suh
		,dataType : "json"
		,success : function(res_data){
			//res_data = {"result" : true} or {"result" : false}  
			if(res_data.result){
				//사용가능
				$("#msg_id").html("사용가능한 아이디입니다.").css("color","blue");
				$("#btn_register").prop("disabled",false);
			}else {
				//이미사용중
				$("#msg_id").html("이미 사용중인 아이디입니다.").css("color","red");
			}
		}
		,error : function(err){
			alert(err.responseText);
		}
	})
	
	}//end : check_id()
	
	function find_addr(){
		   new daum.Postcode({
			   
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            //console.log(data);
		            $("#mem_zippcode").val(data.zonecode);
		            $("#mem_addr").val(data.address);
		        }
		    }).open();
	}//end : find_addr()
	
	function send(f){
		//입력값 검증작업(입력유무)
		if($("#mem_name").val()==""){
			
		}
		
		//전송대상지정
		f.action = "insert.do" // MemberInsertAction
		
		//서버전송
		f.submit
	}//end : send(f)
	
</script>
</head>
<body>
	<form action="" class="form-inline">
		<div id="box">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>회원가입</h4>
				</div>
				<div class="panel-body">
					<div class="common">
						<label>name</label> <input class="form-control" name="mem_name">
					</div>
					<div class="common">
						<label>id</label> 
						<input class="form-control" name="mem_id" id="mem_id" onkeyup="check_id();">
						<span id="msg_id"></span>
					</div>
					<div class="common">
						<label>pwd</label> <input class="form-control" type="password" name="mem_pwd">
					</div>
					<div class="common">
						<label>email</label> <input class="form-control" type="email" name="mem_email">
					</div>
					<div class="common">
						<label>zippcode</label> <input class="form-control" name="mem_zippcode" id="mem_zippcode">
						<input class="btn btn-primary" type="button" value="주소찾기" onclick="find_addr();">
						<br><br><label>addr</label> <input size="65%" class="form-control" name="mem_addr" id="mem_addr">
					</div>

					<div class=common style="text-align: center;">
						<input type="button" class="btn btn-success" value="목록보기" style="margin-right: 20px; ">
						<input type="button" class="btn btn-info" value="회원가입" id="btn_register" disabled="disabled"
						onclick="send(this.form);">
					</div>
					
				</div>
			</div>
		</div>
	</form>
</body>
</html>