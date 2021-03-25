<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.temp.*"%>
<%
   EmpDAO dao=new EmpDAO();
   List<EmpVO> list=dao.empListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <h1>사원 목록</h1>
    <table border=1 bordercolor=black>
      <tr bgcolor=#ccffcc>
        <th>사번</th>
        <th>이름</th>
        <th>직위</th>
        <th>입사일</th>
        <th>급여</th>
      </tr>
      <%
          for(EmpVO vo:list)
          {
      %>
              <tr>
                <td><%=vo.getEmpno() %></td>
                <td><%=vo.getEname() %></td>
                <td><%=vo.getJob() %></td>
                <td><%=vo.getHiredate().toString() %></td>
                <td><%=vo.getSal() %></td>
              </tr>
      <%
          }
      %>
    </table>
  </center>
</body>
</html>









