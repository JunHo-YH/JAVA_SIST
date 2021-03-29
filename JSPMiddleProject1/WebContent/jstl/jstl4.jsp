<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String color = "Red, green, blue, yellow, black";
request.setAttribute("color", color);
%>
<%--
	<c:set var="color" value="<%=color%>"  권장사항
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>자바 사용</h3>
	<ul>
		<%
		StringTokenizer st = new StringTokenizer(color, ",");
		while (st.hasMoreTokens()) {
		%>
		<li><%=st.nextToken()%></li>
		<%
		}
		%>
	</ul>

	<h3>JSTL 사용</h3>
	<ul>
		<c:forTokens var="col" items="${color }" delims=",">

			<li>${col }</li>
		</c:forTokens>
	</ul>
</body>
</html>