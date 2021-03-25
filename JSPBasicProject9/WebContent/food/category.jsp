<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
<%
    String cno=request.getParameter("cno");
    FoodCategoryVO vo=dao.foodInfoData(Integer.parseInt(cno));
    List<FoodVO> list=dao.foodCategoryFoodData(Integer.parseInt(cno));
    for(FoodVO fvo:list)
    {
    	String s=fvo.getPoster();
    	s=s.substring(0,s.indexOf("^"));
    	fvo.setPoster(s);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="jumbotron">
   <h1 class="text-center"><%=vo.getTitle() %></h1>
   <h4 class="text-center"><%=vo.getSubject() %></h4>
  </div>
  <div class="row">
   <%
      for(FoodVO fvo:list)
      {
   %>
         <table class="table">
          <tr>
            <td width=30% class="text-center" rowspan="3">
             <img src="<%=fvo.getPoster() %>" width=100%>
            </td>
            <td width="70%">
             <h3><%=fvo.getTitle() %><span style="color:orange"><%=fvo.getScore() %></span></h3>
            </td>
          </tr>
          <tr>
            <td width=70%><%=fvo.getAddress() %></td>
          </tr>
          <tr>
            <td width=70% height=60></td>
          </tr>
         </table>
   <%
      }
   %>
  </div>
</body>
</html>










