<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl Core : forEach,if,Choose 연결하기 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jstl Functions : substring,indexOf,length.... -->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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



<style type="text/css">
#box {
	width: 700px;
	margin: auto;
	margin-top: 50px;
}

#title {
	text-align: center;
	font-weight: bold;
	font-size: 28px;
	/* color:rgb(51,122,183); */
	color: #337AB7;
	text-shadow: 1px 1px 2px black;
}

#error_msg {
	text-align: center;
	color: red;
	font-size: 20px;
	font-weight: bold;
}
.common{
	border: 1px solid #dddddd;
	padding:5px;
	margin-bottom:5px;
	box-shadow: 1px 1px 1px #bbbbbb;
}
.content{
	min-height:80px;
}
<<<<<<< HEAD

</style>
</head>
<body>
	<div id="box">
		<h1 id="title">:::: 방명록 ::::</h1>
		<div style= "margin-top:30px;margin-bottom: 30px;">
			<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		<!-- 데이터 -->

		<!-- 데이터가 없을경우 -->
		<c:if test="${empty requestScope.list }">
			<div id="error_msg">등록된 게시물이 없습니다.</div>
		</c:if>

		<!-- for(VisitVo vo: list) 동일함. -->
		<c:forEach var="vo" items="${list }">
			<!-- Bootstrap Panal -->
			<div class="panel panel-primary">
			
				<!-- 제목 -->
				<div class="panel-heading">
					<h4><b>${vo.name }</b>님의 글</h4>
				</div>
				<!-- 내용 -->
				<div class="panel-body">
					<form action="" class="form-inline">
						<div class="common content">${vo.content }</div>
						<!-- EL 일반데이터 바로 가져오기 -->
						<div class="common regdate"><label>등록일자</label> : ${vo.regdate }</div>
						<!-- EL함수 사용해서 데이터 가져오기 -->
						<div class="common regdate"><label>등록일자</label> : ${fn:substring(vo.regdate,0,16) }
																			(${vo.ip })</div>
						<div class="common pwd">
							<label>비밀번호</label> : <input class="form-control" type="password" name="c_pwd">
							 <input class="btn btn-info" type="button" value="수정"> 
							 <input class="btn btn-danger" type="button" value="삭제">
=======
</style><!-- end style -->

<script type="text/javascript">
	function del(f){
		let idx = f.idx.value;            // 게시물번호
		let pwd = f.pwd.value;            // 게시물비밀번호
		let c_pwd = f.c_pwd.value.trim(); // 확인비밀번호
		
		if(c_pwd==""){
			alert("삭제할 게시물의 비밀번호를 입력하세요");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		
		//비밀번호 맞는지 여부 체크
		if(pwd != c_pwd){
			alert("비밀번호가 일치하지 않습니다.")
			//f.c_pwd.value="";
			f.c_pwd.focus();	
			return;
		}
		
		//삭제 확인 confirm 함수 사용
		if(confirm("정말 삭제 하시겠습니까?")==false){
			return;
		}
		
		//삭제 처리 요청 (삭제할 idx 번호만 넘기고 form으로 넘겨도 되지만 불필요한 데이터가 많이 전달되기때문에 get방식으로 idx만 넘긴다.)
		location.href="delete.do?idx="+idx; //VisitDeleteAction 으로 보낸다.
		
		
	}//end : del(f)
	
	function modify_form(f){
		let idx = f.idx.value;            // 게시물번호
		let pwd = f.pwd.value;            // 게시물비밀번호
		let c_pwd = f.c_pwd.value.trim(); // 확인비밀번호
		
		if(c_pwd==""){
			alert("수정할 게시물의 비밀번호를 입력하세요");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		
		//비밀번호 맞는지 여부 체크
		if(pwd != c_pwd){
			alert("비밀번호가 일치하지 않습니다.")
			//f.c_pwd.value="";
			f.c_pwd.focus();	
			return;
		}
		
		//수정 확인하기
		if(confirm("정말 수정 하시겠습니까?")==false){
			return;
		}
		
		//수정 처리 요청 (수정할 idx 번호만 넘기고 form으로 넘겨도 되지만 불필요한 데이터가 많이 전달되기때문에 get방식으로 idx만 넘긴다.)
		location.href="modify_form.do?idx="+idx; //VisitModifyFormAction 으로 보낸다.
		
	} // end : modify_form()
	
</script> <!-- end : js -->

</head>
<body>
	<div id="box">
		<h1 id="title">:::: 방명록 ::::</h1>
		<div style= "margin-top:30px;margin-bottom: 30px;">
			<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		<!-- 데이터 -->

		<!-- 데이터가 없을경우 -->
		<c:if test="${empty requestScope.list }">
			<div id="error_msg">등록된 게시물이 없습니다.</div>
		</c:if>

		<!-- for(VisitVo vo: list) 동일함. -->
		<c:forEach var="vo" items="${list }">
			<!-- Bootstrap Panal -->
			<div class="panel panel-primary">
			
				<!-- 제목 -->
				<div class="panel-heading">
					<h4><b>${vo.name }</b>님의 글</h4>
				</div>
				<!-- 내용 -->
				<div class="panel-body">
					<form action="" class="form-inline">
					<input type="hidden" name="idx" value=${vo.idx }>
					<input type="hidden" name="pwd" value=${vo.pwd }>
						<div class="common content">${vo.content }</div>
						<!-- EL 일반데이터 바로 가져오기 -->
						<div class="common regdate"><label>등록일자</label> : ${vo.regdate }</div>
						<!-- EL함수 사용해서 데이터 가져오기 -->
						<div class="common regdate"><label>등록일자</label> : ${fn:substring(vo.regdate,0,16) }
																			(${vo.ip })</div>
						<div class="common pwd">
							<label>비밀번호</label> : <input class="form-control" type="password" name="c_pwd">
							 <input class="btn btn-info" type="button" value="수정"
							 		onclick="modify_form(this.form);"> 
							 <input class="btn btn-danger" type="button" value="삭제"
							 		onclick="del(this.form)">
>>>>>>> branch 'master' of https://github.com/HappyLeo7/webStudy.git
						</div>
					</form>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>