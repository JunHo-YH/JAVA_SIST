<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="str" value=" Hello JSTL!!!" />
<c:set var="arr" value="red,green, blue, yellow, cyan"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
str값: ${str}<br>
STR의 문자 갯수:${fn:length(str) }<br>
str 좌우의 공백문자 제거: ${fn:trim(str) }<br>
STR의 문자 갯수:${fn:length(str) }<br>
str문자 제어: ${fn:substring(str,1,6) }<br>
str문자 변ㄱ뎡:${fn:replace(str," ","_") }<br>
<c:set var="color" value="${fn:split(arr,',') }"/>
<c:forEach var="cc" items="${color }">
	${cc }<br>
</c:forEach>
</body>
</html>