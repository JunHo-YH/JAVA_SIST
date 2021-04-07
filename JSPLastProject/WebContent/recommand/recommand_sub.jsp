<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
    <tr>
      <td class="text-center">
       <c:forEach var="sub" items="${list }">
         <span class="btn btn-sm btn-success">${sub }</span>
       </c:forEach>
      </td>
    </tr>
  </table>
</body>
</html>