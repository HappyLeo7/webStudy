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
        
        	<!-- 상품소개 서브메뉴 -->
        <div id="aside">
        	<%@include file="./menu/submenu_product.jsp" %>
        </div>

        <div id="content">
        	<c:if test="${(empty param.submenu ) or param.submenu =='new_product' }">
        		<%@include file="./content/product/new_product.jsp" %>
        	</c:if>
        	<c:if test="${ param.submenu == 'estimate' }">
        		<%@include file="./content/product/estimate.jsp" %>
        	</c:if>
        	<c:if test="${param.submenu eq 'carry_over_product' }">
        		<%@include file="./content/product/carry_over_product.jsp" %>
        	</c:if>
        	<c:if test="${param.submenu eq 'q_a' }">
        		<%@include file="./content/product/q_a.jsp" %>
        	</c:if>
        </div>
        <div id="footer">
        	<%@include file="./footer/footer.jsp" %>
        </div>
        

    </div>
</body>
</html>