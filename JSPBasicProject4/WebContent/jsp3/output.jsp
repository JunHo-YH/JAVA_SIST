<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     out => println() | <%= %>
     application => getInitParameter(),getRealPath()
     pageContext => include,forward
 --%>
<%
   
   String fn=request.getParameter("file");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <img src="<%=fn%>">
</body>
</html>