<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    /*
     	EL(Expression Language) : 데이터를 표현하는 언어
    	 1. 문자 / 숫자 / boolean / null 표현한다.
    	 2. 각 scope내 또는 parameter에 저장된 값만 표현할 수 있다.
    	 3. 형식
    	 	${ 표현식 }
    */
    
    
    %>
    <!-- html 주석 
    	EL형식 : \${}
    -->
    <%-- jsp 주석 -> jsp서블릿 변환시 안넘어간다. --%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h4>EL연산자(산술)</h4>
<hr>
\${3+1} => ${3+1} <br>
\${3-1} => ${3-1} <br>
\${3*2} => ${3*2} <br>
\${10/3} => ${10/3} <br>
or<br>
<%--  \${10 div 3} => ${10 div 3}<br> --%>
 <br>
\${10%3} => ${10%3} <br>
or<br>
\${10 mod 3} => ${10 mod 3} <br>

<hr>
 <h4>EL 연산자(관계)</h4>
<hr>
<!-- gt : greater than -->
\${3 > 2} => ${3 > 2} <br>
\${3 gt 2} => ${3 gt 2} <br>
<br>
<!-- ge: greater equal -->
\${3 >= 2} => ${3 >= 2} <br>
\${3 ge 2} => ${3 ge 2} <br>
<br>
<!-- lt: less than -->
\${3 < 2} => ${3 < 2} <br>
\${3 lt 2} => ${3 lt 2} <br>
<br>
<!-- le: less equal -->
\${3 <= 2} => ${3 <= 2} <br>
\${3 le 2} => ${3 le 2} <br>
<br>
<!-- eq: equal -->
\${3 == 2} => ${3 == 2} <br>
\${3 eq 2} => ${3 eq 2} <br>
<br>
<!-- ne: not equal -->
\${3 != 2} => ${3 != 2} <br>
<%-- \${3 ne 2} => ${3 ne 2} <br> --%>

<hr>
	<h4>EL 연산자(3항연산자 및 empty)</h4>
<hr>
\${(3>=0)?'양수':'음수'} => ${(3>=0)?'양수':'음수'}<br>


<!-- el1.jsp?msg=안녕 -->
전달 메세지 : ${ (empty param.msg) ? '전달메세지 없음':param.msg }<br>
</body>
</html>