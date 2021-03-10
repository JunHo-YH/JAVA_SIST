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
  out.println("<html>");
	out.println("<head>");
	out.println("<link rel=stylesheet href=\"css/table.css\">");
	out.println("<style type=text/css>");
	out.println("td,th{font-family:맑은 고딕;font-size:9pt;height:35px}");
	out.println("</style>");
	out.println("</head>");
	out.println("<body>");
	out.println("<center>");
	out.println("<h1>글쓰기</h1>");
	// 입력된 모든 데이터를 doPost로 전송 => <form>
	out.println("<form method=post action=BoardInsertServlet autocomplete=off>");
	// 입력창을 이용해서 => 글쓰기가 가능하게 만들어 준다 
	out.println("<table class=table-content width=600>");
	// 이름입력
	out.println("<tr>");
	out.println("<th width=20% align=right>이름</th>");
	out.println("<td width=\"80%\">");
	out.println("<input type=text name=name size=15>");
	out.println("</td>");
	out.println("</tr>");
	// 제목입력
	out.println("<tr>");
	out.println("<th width=20% align=right>제목</th>");
	out.println("<td width=\"80%\">");
	out.println("<input type=text name=subject size=50>");
	out.println("</td>");
	out.println("</tr>");
	// 내용입력
	out.println("<tr>");
	out.println("<th width=20% align=right>내용</th>");
	out.println("<td width=\"80%\">");
	out.println("<textarea rows=10 cols=55 name=content></textarea>");
	out.println("</td>");
	out.println("</tr>");
	
	// 비밀번호
	out.println("<tr>");
	out.println("<th width=20% align=right>비밀번호</th>");
	out.println("<td width=\"80%\">");
	out.println("<input type=password name=pwd size=15>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td colspan=2 align=center>");
	out.println("<input type=submit value=글쓰기>");
	out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");
	// HTML / CSS / JavaScript
	out.println("</td>");
	out.println("</tr>");
	
	out.println("</table>");
	out.println("</form>");
	out.println("</center>");
	out.println("</body>");
	out.println("</html>");
  %>
</body>
</html>