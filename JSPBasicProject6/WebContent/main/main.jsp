<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      특정부분에 다른 JSP를 첨부해서 사용 => 파일을 나눠서 작업이 가능 
      유지보수가 좋다 => 조립식 
      include => (HTML:<iframe>)
      <%@ include file=""%> : 정적 => 메뉴 , footer
      <jsp:include Page=""/> : XML의 단점 문법이 엄격하다 => 동적
            1. 대소문자 구분 , 2. 열고 닫기가 명확 , 3. 속성은 반드시 ""
            
      1. JSP + JSP => 소스를 합쳐서 => 컴파일  (<%@ include%>)
      2. JSP마다 컴파일 => HTML => <jsp:include>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
  width: 960px;
  margin: 0px auto;
}
</style>
</head>
<body>
  <%--
         포함하고 있는 모든 JSP는 request공유한다 
   --%>
  <%-- <jsp:include page="header.jsp"></jsp:include> --%>
  <%@ include file="header.jsp" %>
  <div style="height:30px"></div>
  <div class="container">
    <jsp:include page="home.jsp"></jsp:include>
  </div>
</body>
</html>











