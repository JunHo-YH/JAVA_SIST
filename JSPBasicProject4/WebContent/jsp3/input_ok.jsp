<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.*,com.oreilly.servlet.multipart.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    String s=application.getRealPath("/jsp3");// 톰캣이 읽어가는 실제 경로명
    String path=s;
    String enctype="UTF-8"; // 한글 파일명
    int size=1024*1024*100;//100MB
    MultipartRequest mr=
        new MultipartRequest(request,path,size,enctype,
        		new DefaultFileRenamePolicy());
    // new DefaultFileRenamePolicy() aaa.jpeg => aaa1.jpeg (1) 
    String name=mr.getOriginalFileName("upload");
    System.out.println(name);
    response.sendRedirect("output.jsp?file="+name);
%>