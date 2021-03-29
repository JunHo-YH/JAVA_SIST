<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<String> list = new ArrayList<String>();
list.add("이순신");
list.add("춘향이");
list.add("박효신");
list.add("청하");
%>
<%-- request.setAttribute("list",list) --%>
<c:set var="list" value="<%=list%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반 자바</h3>
	<ul>
		<%
		for (String name : list) {
		%>
		<li><%=name%></li>
		<%
		}
		%>
	</ul>

	<h3>JSTL사용(일반 변수는 사용할 수 없다, request, session)</h3>
	<ul>
		<c:forEach var="name" items="${list }">
			<li>${name }</li>
		</c:forEach>
	</ul>
</body>
</html>