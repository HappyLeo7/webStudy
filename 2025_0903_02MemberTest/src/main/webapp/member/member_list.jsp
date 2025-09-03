<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- jstl core -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	#box{
		width : 1000px;
		margin : auto;
		margin-top : 30px;
	}
	#title{
		text-align : center;
		font-size: 30px;
		font-weight:bold; 
		color: #337AB7;
		text-shadow : 2px 2px 2px;
	}
	.my-title{
		background-color: #999999;
		color : white;
	}
	
</style>

</head>
<body>
	
	<div id="box">

		<h1 id="title">회원목록</h1>
		
		<div style="margin-top: 50px; margin-bottom: 10px;">
			<input class="btn btn-primary"type="button" value="회원가입"
				onclick="location.href='insert_form.do'">
		</div>
		
		<!-- 회원정보 출력 -->
		<table class="table">
			<tr class="my-title">
				<th>회원번호</th>
				<th>회원명</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>아이피</th>
				<th>가입일자</th>
				<th>회원등급</th>
			</tr>
			
			<!-- data 출력-->
			<c:if test="${empty list }">
			<tr>			
				<td colspan="10" align="center">
					<font color="red">등록된 회원정보가 없습니다
					</font>
				</td>				
			</tr>	
			</c:if>
			
			<!-- for문 -->
			<c:forEach var="vo" items="${list}">
			<tr class="">
				<td>${vo.mem_idx }</td>
				<td>${vo.mem_name }</td>
			    <td>${vo.mem_id }</td>
				<td>${vo.mem_pwd }</td>
				<td>${vo.mem_email }</td>
				<td>${vo.mem_zippcode }</td>
				<td>${vo.mem_addr }</td>
				<td>${vo.mem_ip }</td>
				<td>${vo.mem_regdate }</td>
				<td>${vo.mem_grade }</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>