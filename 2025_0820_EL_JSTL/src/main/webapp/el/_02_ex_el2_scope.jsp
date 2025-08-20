<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//EL(조회용 표현언어)
    	//JSP 내장객체 : pageContext , request , session , application ... response , out
    	//			   binding API
    	//			   bind : 연결
    	//pageContext.setAttribute("msg", "pageScope 영역이에요");
    	//request.setAttribute("msg", "requestScope 영역이에요");
	   	//session.setAttribute("msg", "sessionScope 영역이에요");  //접속자 유저별로 하나씩 할당된다.
    	//application.setAttribute("msg", "applicationScope 영역이에요");
    	
    	String name = "홍길동";
					    //  ( key  ,value) <-Map형식
    	request.setAttribute("name",name); 
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${ name }<br>
					  <%-- \${ 영역명.변수명 } --%>
 pageContext영역내의 데이터 : ${pageScope.msg } <br>
 requestContext영역내의 데이터 : ${requestScope.msg } <br>
 sessionContext영역내의 데이터 : ${sessionScope.msg } <br>
 applicationContext영역내의 데이터 : ${applicationScope.msg } <br>
 
 <!-- EL에서 영역명을 생략하면 어떤영역의 테이터가 사용될까? 
 		참조순서 : pageScope -> requestScope -> sessionScope -> applicationScope -->
 ???Scope : ${ msg }
 
</body>
</html>