<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	HTML + JAVA
	
	JAVA영역
	1. <% %>: 스크립트릿 => 일반 자바 코딩 (자바 문법 사용)
	2. <%= %>: 표현식 => 화면에 출력 (세미클론(;)을 사용하지 않는다.)
								out.println(내용);
	3. <%! %>: 선언식 => 메서드 선언, 전역변수
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>구구단</h1>
		<table width=700 border=1 bordercolor=black>
			<tr bgcolor=#ccffcc>
				<th>2단</th>
				<th>3단</th>
				<th>4단</th>
				<th>5단</th>
				<th>6단</th>
				<th>7단</th>
				<th>8단</th>
				<th>9단</th>
			</tr>
		</table>
		
		<table width=700 border=1 bordercolor=black>
			<tr bgcolor=#ccffcc>
				<%
					for(int i=2; i<=9; i++) {
				%>
					<th><%= i+"단" %></th>
				<%
					}
				%>
			</tr>
			<%
				for(int i=1; i<=9; i++) {
			%>
					<tr>
			<%
					for(int j=2; j<=9; j++) {
			%>		
						<td align=center><%= j+"*"+i+"="+(j*i) %></td>
			<%		
					}
			 %>		
			 		</tr>
			 <%
				}
			 %>
		</table>
	</center>
</body>
</html>