<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function m(f){
		
		let idx		=  f.idx.value;          //게시물번호
		let t=f.btn.onclick;
		console.log(f);
		console.log(t);
}
</script>

<script type="text/javascript">
function mm(f){
	
		alert(idx);
	}

</script>

</head>
<body>
	<h3>작성날짜 : ${lastModifyDate }</h3>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화</th>
		</tr>
		<c:forEach var="vo" items="${list }" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>${vo.name }</td>
			<td>${vo.age }</td>
			<td>${vo.tel }</td>
		</tr>
		</c:forEach>
	</table>
	<form action="">
	
 		<input type="button" onclick="m(this.form);" value="버튼" id="btn">
 		<input type="text" value="3" id="idx">
 		
	</form>
	
</body>
</html>