<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%-- 메모리 할당 
     MovieDAO dao=new MovieDAO();
--%>
<jsp:useBean id="dao" class="com.sist.dao.MovieDAO"></jsp:useBean>
<%
    String cno=request.getParameter("cno");
    if(cno==null)
    	cno="1";
    int index=Integer.parseInt(cno);
    List<MovieBean> list=dao.movieListData(index);
    
    // 쿠키 읽기
    List<MovieBean> cList=new ArrayList<MovieBean>();
    Cookie[] cookies=request.getCookies();
    if(cookies!=null && cookies.length>0)
    {
    	for(int i=0;i<cookies.length;i++)
    	{
    		if(cookies[i].getName().startsWith("m"))
    		{
    			String value=cookies[i].getValue();
    			MovieBean bean=dao.movieDetailData(Integer.parseInt(value));
    			cList.add(bean);
    		}
    	}
    }
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
   width:960px;
   margin: 0px auto;
}
</style>
</head>
<body>
   <div style="height:50px"></div>
   <div class="container">
     <div class="row">
       <%
          for(MovieBean bean:list)
          {
       %>
             <div class="col-md-3">
			    <div class="thumbnail">
			      <a href="detail_before.jsp?mno=<%=bean.getMno()%>">
			        <img src="<%=bean.getPoster() %>" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p style="font-size: 8pt"><%=bean.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
       <%
          }
       %>
     </div>
     <div class="row">
      <h3>최근 방문 영화</h3>
      <a href="delete.jsp" class="btn btn-sm btn-success">삭제</a>
      <hr>
      <%-- 쿠키에 저장된 영화를 보여준다  --%>
      <%
         for(int i=cList.size()-1;i>=0;i--)
         {
        	 MovieBean b=cList.get(i);
      %>
           <img src="<%=b.getPoster() %>" width=100 height=150>
      <%
      
         }
      %>
     </div>
   </div>
</body>
</html>






