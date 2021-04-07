<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<String> list1=new ArrayList<String>();
    list1.add("홍길동");
    list1.add("심청이");
    list1.add("박문수");
    
    List<String> list2=new ArrayList<String>();
    list2.add("남자");
    list2.add("여자");
    list2.add("남자");
%>
<c:set var="list1" value="<%=list1 %>"/>
<%-- request.setAttribute("list1",list1) --%>
<c:set var="list2" value="<%=list2 %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <ul>
    <c:set var="i" value="0"/>
    <c:set var="j" value="0"/>
    <c:set var="k" value="0"/>
    <c:forEach var="vo" begin="0" end="2">
      <li>${name }</li>
    </c:forEach>
  </ul>
</body>
</html>





