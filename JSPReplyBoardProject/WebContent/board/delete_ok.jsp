<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
     // 1. 사용자가 요청한 값을 받는다
     String pwd=request.getParameter("pwd");
     String no=request.getParameter("no");
     String strPage=request.getParameter("page");
     // 2. 오라클 연결 (DAO)
     BoardDAO dao=new BoardDAO();
     boolean bCheck=dao.boardDelete(Integer.parseInt(no), pwd);
     // 3. 이동 
     if(bCheck==true)
     {
    	 response.sendRedirect("list.jsp?page="+strPage);
     }
     else
     {
%>
         <script>
         alert("비밀번호가 틀립니다");
         history.back();
         </script>
<%
     }
%>
