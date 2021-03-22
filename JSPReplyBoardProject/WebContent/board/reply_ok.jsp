<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 한글 
    try
    {
    	request.setCharacterEncoding("UTF-8");
    }catch(Exception ex){}
	//값을 받는다 
	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	/*
	      <input type=hidden name=pno value="1">
	      <input type=hidden name=page value="1234">
	*/
	String pno=request.getParameter("pno");// 상위
	String strPage=request.getParameter("page");
	
	// 묶어서 DAO로 전송 
	BoardVO vo=new BoardVO();
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	
	BoardDAO dao=new BoardDAO();
	// 처리 
	dao.boardReplyInsert(Integer.parseInt(pno), vo);
	// 이동
	response.sendRedirect("list.jsp?page="+strPage);
	
%>







