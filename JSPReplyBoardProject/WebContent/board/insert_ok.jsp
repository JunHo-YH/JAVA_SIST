<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%-- 데이터를 받아서 오라클에 전송--%>
<%
    try
    {
    	request.setCharacterEncoding("UTF-8");//POST
    }catch(Exception ex){}
    String name=request.getParameter("name");
    String subject=request.getParameter("subject");
    String content=request.getParameter("content");
    String pwd=request.getParameter("pwd");
    
    BoardVO vo=new BoardVO();
    vo.setName(name);
    vo.setSubject(subject);
    vo.setContent(content);
    vo.setPwd(pwd);
    
    // DAO를 통해서 => 오라클로 전송 
    BoardDAO dao=new BoardDAO();
    dao.boardInsert(vo);
    // 이동 => list.jsp
    response.sendRedirect("list.jsp");
    
%>






