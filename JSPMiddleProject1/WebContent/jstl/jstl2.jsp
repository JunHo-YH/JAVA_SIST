<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 이용</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test="${i%2 ==0 }">
			${i }는 짝수입니다.<br>
		</c:if>
		<c:if test="${i%2 ne 0 }">
			${i }는 홀수입니다.<br>
		</c:if>
	</c:forEach>
	<%-- 태그가 XML형식으로 만들어져 있다.
		속성="", '' 대소문 구분
		여는 태그, 닫는 태그가 명확해야한다.
	 --%>
</body>
</html>