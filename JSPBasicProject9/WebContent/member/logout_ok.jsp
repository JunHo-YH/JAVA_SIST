<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 전체 정보를 삭제한다
    session.invalidate();
    // main으로 이동 
    response.sendRedirect("../main/main.jsp");
%>