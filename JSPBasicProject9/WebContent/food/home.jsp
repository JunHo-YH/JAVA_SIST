<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%
    String index=request.getParameter("index");
    if(index==null)
       index="1";
    FoodDAO dao=new FoodDAO();
    List<FoodCategoryVO> list=dao.foodCategoryData(Integer.parseInt(index));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="row">
    <a href="main.jsp?index=1" class="btn btn-sm btn-danger">믿고 보는 맛집 리스트</a>
    <a href="main.jsp?index=2" class="btn btn-sm btn-success">지역별 인기 맛집</a>
    <a href="main.jsp?index=3" class="btn btn-sm btn-primary">메뉴별 인기 맛집</a>
   </div>
   <div style="height:20px"></div>
   <div class="row">
     <%
         for(FoodCategoryVO vo:list)
         {
     %>
     
          <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../main/main.jsp?mode=1&cno=<%=vo.getNo()%>">
		        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p><%=vo.getTitle() %></p>
		        </div>
		      </a>
		    </div>
		   </div>
     
     <%
         }
     %>
   </div>
</body>
</html>