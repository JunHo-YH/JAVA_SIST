<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form method=post action="../member/login_ok.jsp">
  <table class="table">
    <tr>
     <td width="10%" class="text-center">ID</td>
     <td width=90%>
       <input type=text name=id class="input-sm">
     </td>
    </tr>
    <tr>
     <td width="10%" class="text-center">PW</td>
     <td width=90%>
       <input type=password name=pwd class="input-sm">
     </td>
    </tr>
    <tr>
      <td colspan="2" class="text-right">
       <button class="btn btn-sm btn-danger">로그인</button>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>