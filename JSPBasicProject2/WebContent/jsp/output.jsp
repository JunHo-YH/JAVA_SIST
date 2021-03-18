<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	사용자가 보내준 데이터를 받아서 처리하는 JSP
    	1. 한글여부 확인
    		인코딩 ==> 디코딩
    	2. 데이터 => name
    	
    	getParameter()
    	getParameterValue()
    	
    	=> <input type=text name="name[0]">
    	=> <input type=text name="name[0]">
    	=> <input type=text name="name[0]">  
    	   ================================== ArrayList
    	   ==> fileUpload
     --%>
<%
	// 1. 자바
	try {
		// 한글 변환 // page83
		request.setCharacterEncoding("UTF-8");
		// 한글 => 인코딩 ==> 받는 경우에 디코딩 (원래값 복원) => setCharacterEncoding("UTF-8")
		/*
		POST방식으로 할 때는 JSP파일에서 request.setCharacterEncoding("UTF-8"); 작성해주고 
		GET방식으로 할 때는 server파일에서 인코딩을 수정

		*/
	}catch(Exception ex) {
		
		ex.printStackTrace();
	}


	String name = request.getParameter("name");
	// name = (name) => name=홍길동
	String password = request.getParameter("pwd");
	// name = pwd
	String sex = request.getParameter("sex");
	String loc = request.getParameter("loc");
	String content = request.getParameter("content");
	
	String[] hobby=request.getParameterValues("hobby");
	// checkbox
	// 2. HTML을 이용해서 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>서버정보 & 클라이언트 정보 확인(로그파일 저장용)</h3>
접속자의 IP:<%= request.getRemoteAddr() %><br>
접속자의 요청경로:<%= request.getRequestURI() %><br>
전체 경로:(서버정보 포함):<%= request.getRequestURL() %><br>
서버 주소: <%=request.getServerName() %><br>
서버 PORT: <%=request.getServerPort() %><br>
서버 Protocol: <%= request.getProtocol() %><br>
데이터 전송 방식: <%= request.getMethod() %><br>
<hr>
<h3>접속자가 보낸 데이터</h3>
이름:<%=name %><br>
비밀번호:<%=password %><br>
성별:<%=sex %><br>
지역:<%=loc %><br>
소개:<%=content %><br>
취미:
	<ul>
	<%
		try{
	%>
	
	
	<%
		for(String h:hobby) {
	%>
		<li><%=h %></li>
	<% 
		}
	%>
	
	<%
		}catch(Exception ex) {
	%>
		<font color=red>취미가 없습니다 !</font>
	<%	
		}
	%>
	</ul>
</body>
</html>







