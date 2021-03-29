<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	EL: 화면 출력
		out.println("")
		<%= %>
		${}
		목적: 자바 / HTML 분리 => MV패턴
								Model => 자바
								View => HTML(JSP)
							=>	MVC패턴
								Model => 자바
								View => HTML(JSP)
								Controller => JAVA와 JSP를 연결
	EL
	연산자 처리
	메서드 처리
	처리 영역
	${일반 변수 출력이 아니다}
	예)
		String name="홍길동";
		${name} (X)
		request.getAttribute("name");
		session.getAttribute("");
	
	
 --%>
 <%
 	String name = "홍길동";
 	request.setAttribute("name", name);
 	// ${requestScope.name}
 	//				  ==== 키명
 	session.setAttribute("nick", "심청이");
 	
 	// 우선순위 request => session => application
 	// 자바에서 데이터를 보낸다면 (request, session)
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: ${name},${requestScope.name} <br>
	<%=request.getAttribute("name") %> <br>
	${sessionScope.name}, ${nick}
</body>
</html>
















