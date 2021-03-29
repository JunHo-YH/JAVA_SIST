<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 다중 조건문 --%>
<c:set var="star" value="5"/>
<c:set var="sex" value="여자"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${star==1 }">★ </c:when>
		<c:when test="${star==2 }">★★ </c:when>
		<c:when test="${star==3 }">★★★ </c:when>
		<c:when test="${star==4 }">★★★★ </c:when>
		<c:when test="${star==5 }">★★★★★ </c:when>
	</c:choose>
	<br>
	<c:choose>
		<c:when test="${sex=='남자' }"> <%--if --%>
			<b>남자입니다.</b>
		</c:when>
		<c:otherwise> <%-- else --%>
			<b>여자입니다.</b>
		</c:otherwise>
	</c:choose>
</body>
</html>