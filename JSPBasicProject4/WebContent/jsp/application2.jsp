<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
      String driver=application.getInitParameter("driver");
      String url=application.getInitParameter("url");
      String username=application.getInitParameter("username");
      String pwd=application.getInitParameter("password");
      application.log("driver:"+driver);
      application.log("url:"+url);
      application.log("username:"+username);
      application.log("password:"+pwd);
      application.log("IP:"+request.getRemoteAddr());
      application.log("Method:"+request.getMethod());
      application.log("URI:"+request.getRequestURI());
  %>
</body>
</html>