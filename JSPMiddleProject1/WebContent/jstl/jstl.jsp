<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	JSTL => 태그형으로 자바 문법을 제작
	core: 변수설정, URL, 제어문
			1) 변수 설정
				<c:set var="s" value="Hello"> => String
				String s = "Hello";(X)
				request.setAttribute("s", "Hello") (O)
				<c:set var="s" value="10"> => int
				===prefix
			
			2) URL
				<c:redirect url="">
				response.sendRedirect("")
				
			3) 제어문
			   조건문: 단일 조건문만 사용할 수 있다. => else 사용 불가
			   	if(조건)
			   	{
			   	
			   	}
			   	<c:if test="조건">
			   	</c:if>
			   선택문
			   	switch(값)
			   	{
			   		case 값: 처리
			   		==
			   		==
			   		==
			   	}
			   	
			   	<c:choose>
			   		<c:when test="조건">처리값</c:when> => case
			   		<c:when test="조건">처리값</c:when> => case
			   		<c:when test="조건">처리값</c:when> => case
			   		<c:otherwise>Default</c:otherwise> => default
			   	</c:choose>
			   반복문
			   	for(int i = 1; i <= 10; i++) {
			   	
			   	}
			   	<c:forEach var="i" begin="1" end="10" step="1">
			   								 ======== ========
			   								 항상 = 포함 step="1"일 경우 생략 가능
			   								 <= or >=          단점: 감소할 수 없다.
			   	for(MovieVO vo:list)
			   	<c:forEach var="vo" items="list">
			   	
			   	StringTokenizer st = new StringTokenizer(s,",");
			   	<c:forTokens var="ss" value="s" delimt=",">
			   	
	fmt: 날짜 변환, 숫자 변환
				<fmt:formatDate> SimpleDateFormat
				<fmt:formatNumber> String.format()
	fn: String, Collection
	xml: XML 파싱 => OXM
	slq: SQL => ORM => MyBatis, DAO, Service

 --%>
 
 <%
 	String name = "이순신";
 	request.setAttribute("name", name);
 %> 
 <c:set var="name" value="심청이"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:<%=name %><br>
	이름:${name }
	<%
		if(name.equals("이순신")){
	
	%>
		<b> 이름은 <%=name %>입니다.</b>
	<%
		}
	%>
	<br>
	<c:if test="${name=='심청이' }">
		<b>이름은 ${name }입니다.</b>
	</c:if>	

</body>
</html>