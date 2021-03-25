<%@page import="com.sist.dao.JSPChange"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
    // 화면 변경   main.jsp?page=1
    String mode=request.getParameter("mode");
    if(mode==null)
    	mode="0";
    int no=Integer.parseInt(mode);
    String main_jsp=JSPChange.change(no);
    //세션에 저장되어 있는 데이터 읽기
    String id=(String)session.getAttribute("id"); // 없는 경우:null 
    String log_jsp="";
    if(id==null)
    	log_jsp="../member/login.jsp";
    else
    	log_jsp="../member/logout.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main.jsp">맛집추천</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.jsp">Home</a></li>
      <%
         if(id==null)
         {
      %>
      <li><a href="#">회원가입</a></li>
      <%
         }
         else
         {
      %>
      <li><a href="#">회원수정</a></li> 
      <%  	 
         }
      %>
      <li><a href="#">맛집추천</a></li>
      <%
        if(id!=null)
        {
      %>
      <li><a href="#">마이페이지</a></li>
      <%
        }
      %>
    </ul>
  </div>
</nav>
<div style="height: 30px"></div>
<div class="container">
 <div class="col-sm-3">
   <jsp:include page="<%=log_jsp %>"></jsp:include>
 </div>
 <div class="col-sm-9">
   <jsp:include page="<%=main_jsp %>"></jsp:include>
 </div>
</div>
</body>
</html>






