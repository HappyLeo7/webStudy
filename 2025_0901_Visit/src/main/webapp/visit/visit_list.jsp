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
						</div>
					</form>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>