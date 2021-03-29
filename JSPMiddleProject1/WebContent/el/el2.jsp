<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>

<jsp:useBean id="model" class="com.sist.model.SawonModel"></jsp:useBean>
<!-- SawonModel model = new SawonModel(); -->

<%
	// Controller 영억: 클라이언트가 요청 => 요청을 받아서 해당 Model을 찾고
	// 메서드를 호출
	model.sawonInit(request); // Call By Reference 방식
	model.sawonDetailData(request); // VO
	model.sawonTwoData(request);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: ${name }<br>
	사번: ${vo.sabun },${vo.getSabun() }<br>
	이름: ${vo.name }, ${vo.getName() }<br>
	부서: ${vo.dept }, ${vo.getDept() }<br>
	이름: ${first+=last } <!-- 문자열 결합하려면 +가 아니라 +=를 입력해야한다. -->
</body>
</html>