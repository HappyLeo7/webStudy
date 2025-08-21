<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/mainmenu.css">
    <link rel="stylesheet" href="../css/submenu.css">
</head>
<body>
    <div id="main_box">
        <div id="header">
        	<%@include file="./header/header.jsp" %>
        </div>
        
        	<!-- 고객소개 서브메뉴 -->
        <div id="aside">
        	<%@include file="./menu/submenu_costomer.jsp" %>
        </div>

        <div id="content">
        	<c:if test="${param.submenu == 'customer_board' }">
        		<%@include file="./content/costomer/customer_board.jsp" %>
        	</c:if>
        	<c:if test="${param.submenu == 'edit_member_information' }">
        		<%@include file="./content/costomer/edit_member_information.jsp" %>
        	</c:if>
        	<c:if test="${param.submenu == 'data_room' }">
        		<%@include file="./content/costomer/data_room.jsp" %>
        	</c:if>
        </div>
        
        <div id="footer">
        	<%@include file="./footer/footer.jsp" %>
        </div>
        

    </div>
</body>
</html>