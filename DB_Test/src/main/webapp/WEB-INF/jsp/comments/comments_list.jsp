<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/comments_list.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	document.getElementById("comments_btn").addEventListener("keydown" function(e){
		if(e.key=="Enter"){
		console.log(e)	
		alert("엔터함수체크")
		location.href="/comments_insert.jsp";
		}
	})
</script>
</head>
<body>

	<%-- ${requestScope } --%>

	<%-- ${requestScope.list.get(1).getCommentes_name() } --%>
	<div id="main_box">
		<div id="comments_h2_box">
			<h2 class="comments_h2">댓글</h2>
		</div>
		<div id="comments_insert_button">
			<input type="button" value="댓글쓰기" id="comments_btn">
		</div>
		<table class="table table-hover table-striped">
			<tr class="Warning">
				<th>댓글번호</th>
				<th>사용자이름</th>
				<th>댓글내용</th>
				<th>댓글비번</th>
				<th>댓글IP</th>
				<th>댓글작성일</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.commentes_idx }</td>
					<td>${vo.commentes_content}</td>
					<td>${vo.commentes_name}</td>
					<td>${vo.commentes_pwd}</td>
					<td>${vo.commentes_ip}</td>
					<td>${vo.commentes_regdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	

</body>
</html>