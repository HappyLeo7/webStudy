<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%!
 	// 느낌표는 jsp선언부이다
 	
 	// 변수 선언
	int n ;
	
	//메소드 선언
	void info() {
		System.out.println("정보출력");
	}
	
 %>   
    
    <%
    
    	//Script Let
    	// _jspService()내의 영역
    	int x=10;
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	나 JSP야 ~~<br>
	<!-- JSP 표현식 -->
	x= <%= x %>
</body>
</html>