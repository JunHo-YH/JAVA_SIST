<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String mno=request.getParameter("mno");

    // 쿠키전송 
    /*
        1. 쿠키 생성 
        
        2. 쿠키 저장
        3. 쿠키를 클라이언트로 전송 
    */
    // 1. 쿠키 생성 : 내장객체가 아니다 
    //int a="10";
    Cookie cookie=new Cookie("m"+mno,mno);// 값은 문자열만 저장이 가능 
    cookie.setMaxAge(24*60*60);// 저장 기간 
    response.addCookie(cookie);// 클라이언트로 전송 
    response.sendRedirect("detail.jsp?mno="+mno);
%>




