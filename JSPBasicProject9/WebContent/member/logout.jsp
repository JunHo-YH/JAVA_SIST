<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form method=post action="../member/logout_ok.jsp">
  <table class="table">
    <tr>
     <td>
       <%= session.getAttribute("name") %>님
     </td>
    </tr>
    <tr>
     <td width=90%>
      쪽지(10) &nbsp; 메일(1) 
     </td>
    </tr>
    <tr>
      <td class="text-right">
       <button class="btn btn-sm btn-danger">로그아웃</button>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>