<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//Java Code
    	//a.jsp에 접속한 클라이언트에게 재 접속에 대한 정보를 넘겨준다.
    	System.out.print("--[a.jsp 다녀감]--");
    	response.sendRedirect("b.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나 a.jsp 야!!!
</body>
</html>