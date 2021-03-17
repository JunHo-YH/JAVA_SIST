<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	public class basic4_jsp extends HttpServlet {
		public void _jspInit(){} => web.xml
		public void _jspDestory(){} => 메모리 해제
		public vodi _jspService(){} => 화면 출력(jsp가 들어가는 메서드) {
					_jspService(){} => doGet()/doPost()
			
			<% %>
			<%= %>
		}
	}
 --%>
<%!
	public int add(int a, int b) {
	return a+b;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 10;
		int b = 20;
		int c = add(a,b);
	%>
	<%= c %>
</body>
</html>