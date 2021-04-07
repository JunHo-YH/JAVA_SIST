<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<String> list1=new ArrayList<String>();
    list1.add("홍길동");
    list1.add("심청이");
    list1.add("박문수");
    List<String> list2=new ArrayList<String>();
    list2.add("홍길동1");
    list2.add("심청이1");
    list2.add("박문수1");
%>
<c:set var="list1" value="<%=list1 %>"/>
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
  <c:forEach var="s" items="${list1 }" varStatus="ss">
     <c:if test="${ss.index%2==0 }">
       ${list1[i]}
       <c:set var="i" value="${i+1 }"/>
     </c:if>
     <c:if test="${ss.index%2==1 }">
       ${list2[j]}
       <c:set var="j" value="${j+1 }"/>
     </c:if>
  </c:forEach>
  </ul>
</body>
</html>