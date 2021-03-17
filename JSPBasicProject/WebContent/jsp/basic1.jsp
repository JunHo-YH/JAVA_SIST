<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%--
	JSP: JavaServer Page = 서버에서 실행하는 자바 (View단: 화면)
	= JSP 생명주기
	= 지시자
	   1. page => JSP파일에 대한 정보
	   			  브라우저에 전송하는 방법
	   			  한글 코드
	   			  라이브러리 추가
	   			  에러시에 이동 파일
	   2. include => JSP 특정 영역에 다른 JSP를 추가할 때 사용
	   3. taglib
	  JSP에서 자바 사용법
	  선언식: <%! %> => 메서드를 만들 경우
	  표현식: <%= %> => out.println()대신 사용==> 화면 출력
	  스크립틀릿: <% %> => 일반 자바 (변수 선언, 데이터베이스 연결, 메서드 호출)
	  
	  = 내장 객체(미리 생성된 객체)
	  	***1. request 
	  	***2. response
	  	***3. session
	  	4. out
	  	***5. pageContext : include
	  	***6. application
	  	7. config
	  	8. exception
	  	9. page
	  	= JSP 액션태그
	  	 <jsp:include> <jsp:forward> <jsp:useBean> <jsp:setProperty>
	  	= JavaBean => ~VO (settter/getter)
	  	= 표현식: EL (Expression language)
	  	= JSTL: 태그로 자바문법
	  	= MVC
	  	= DataBase연동 (DAO)
	  	
	  	
	  	= 지시자
	  	 =지시자 사용법
	  	 <%@ page|include|taglib
	  	 	속성="값" 속성="값" %>
	  	1) 속성
	  	 	= 브라우저에 어떤 형식의 파일을 보낼지 설정
	  	 	contentType="text/html"
	  	 	contentType="text/xml"
	  	 
	  	
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="a.jsp">이동</a>
	<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String today = sdf.format(date);
	%>
	<%= today %>

</body>
</html>