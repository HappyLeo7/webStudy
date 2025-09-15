<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- JSTL Core -->
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
    <!-- JSTL Fmt : 날짜나 숫자 포맷사용가능-->
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <style type="text/css">
 	img{
 		width:120px;
 		height:100px;
 	}
 </style>
</head>
<body>
<table class="table">
	<tr>
		<th>이미지</th>
		<th>상품명</th>
		<th>최저가</th>
		<!-- <th>최고가</th> -->
		<th>판매처(몰)</th>
	</tr>	
	
	<!-- 다른 부라우저에서 화페단위가 안나오면 한국 원화로 바꿀시 변경해야한다.  -->
	<fmt:setLocale value="ko_kr"/>
	
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>
			 	<img alt="" src="${vo.image }"> 
			</td>
			<td>
			 	<a href="${vo.link }" target="_blank">${vo.title }</a> 
			</td>
			<td>
				<fmt:formatNumber type="currency" value="${vo.lprice }"/>
			</td>
			<%-- <td>
				${vo.hprice }
			</td> --%>
			<td>
				${vo.mallName }
			</td>
		</tr>
	</c:forEach>
</table>
 검색된 상품정보 ...
</body>
</html>