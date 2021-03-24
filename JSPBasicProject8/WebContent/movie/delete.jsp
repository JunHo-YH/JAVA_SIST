<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    Cookie[] cookies=request.getCookies();
    if(cookies!=null && cookies.length>0)
    {
    	for(int i=0;i<cookies.length;i++)
    	{
    		if(cookies[i].getName().startsWith("m"))
    		{
    			cookies[i].setMaxAge(0);// 삭제
    			response.addCookie(cookies[i]);
    		}
    	}
    }
    response.sendRedirect("list.jsp");
%>