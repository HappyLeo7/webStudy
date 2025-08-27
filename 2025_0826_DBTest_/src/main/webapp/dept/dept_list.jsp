<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- JSTL Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>::::부서목록::::</h2>
	<hr>


	<table border="1" width="500">
		<!-- title -->
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
		</tr>

		<!-- data -->
		<!-- for(DeptVo vo : list) 동일 -->
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.deptno } / ${vo.getDeptno() }</td>
				<td>${vo.dname }</td>
				<td>${vo.loc }</td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>