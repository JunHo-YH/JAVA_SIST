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
   <h2 class="text-center"><%=vo.getTitle() %></h2>
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
             <a href="main.jsp?mode=2&no=<%=fvo.getNo()%>&cno=<%=cno%>">
             <img src="<%=fvo.getPoster() %>" width=200 height=150 class="img-rounded">
             </a>
            </td>
            <td width="70%">
             <h3><a href="main.jsp?mode=2&no=<%=fvo.getNo()%>&cno=<%=cno%>"><%=fvo.getTitle() %></a>&nbsp;<span style="color:orange"><%=fvo.getScore() %></span></h3>
            </td>
          </tr>
          <tr>
            <td width=70% style="color:gray"><%=fvo.getAddress().substring(0,fvo.getAddress().indexOf("지")) %></td>
          </tr>
          <tr>
            <td width=70% height=40>
            <pre style="white-space: pre-wrap;border:none;background-color: white;font-family: 맑은 고딕">영국음식이 이렇게 맛있다니 재방문의사 매우 있음 셰퍼드파이 어디선가 먹어본 맛인데 정말 맛있었다 다음에 가도 셰퍼드파이는 꼭 주문해야지 피쉬앤칩스 비릴줄 알았는데 그런거 없고 부드럽고 맛있었다</pre>
            </td>
          </tr>
         </table>
         
   <%
      }
   %>
  
  </div>
</body>
</html>










