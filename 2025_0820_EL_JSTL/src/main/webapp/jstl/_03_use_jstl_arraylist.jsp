<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	List<String> sido_list = new ArrayList<String>();
    sido_list.add("서울"); //0
    sido_list.add("경기"); //1
    sido_list.add("인천"); //2
    sido_list.add("강원"); //3
    sido_list.add("제주"); //4
    pageContext.setAttribute("sido_list", sido_list);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
 시도목록
<hr>

<ul>
	<!-- for(String sido : pageScope.sido_list) 
			varStaus="i"
			index : 첨자
			count : 순번
	-->
	<c:forEach var="sido" items="${pageScope.sido_list}" varStatus="i">
		<li>${i.count}번째 :  ${ sido } ${ i.index}</li>
		
	</c:forEach>
</ul>

</body>
</html>