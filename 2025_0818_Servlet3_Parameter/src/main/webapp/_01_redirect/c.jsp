<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	System.out.println("--[c.jsp가 d.jsp를 부른다]--");
    	//서버내부에서 이동시킨다.
    	RequestDispatcher disp = request.getRequestDispatcher("d.jsp");
    
    	disp.forward(request,response);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나 c.jsp야 !!
</body>
</html>