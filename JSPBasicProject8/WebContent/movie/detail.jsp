<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MovieDAO"></jsp:useBean>
<%
    // list.jsp(영화번호 전송)=> 영화번호를 받아서 해당 영화의 모든 데이터 요청
    String mno=request.getParameter("mno");
    // DAO연결 => 메모리 할당 
    MovieBean bean=dao.movieDetailData(Integer.parseInt(mno));		
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
  <div class="contanier">
    <%--
         <!ENTITY lt "<">  ==> &변수; => &lt;
         <!ENTITY gt ">">
         <!ENTITY nbsp " "> => &nbsp;
         <!ENTITY amp """>  &amp;
     --%>
    <h3 class="text-center">&lt;<%= bean.getTitle()%>&gt; 상세보기</h3>
    <div class="row">
      <table class="table">
       <%--
            동영상 : <embed> , <object> , <iframe>
                   <video>
        --%>
        <tr>
          <td>
            <embed src="http://youtube.com/embed/<%=bean.getKey()%>" width=960 height=350></embed>
          </td>
        </tr>
      </table>
    </div>
    <div class="row">
     <table class="table">
       <tr>
        <td width=30% class="text-center" rowspan="9">
          <img src="<%=bean.getPoster() %>" width=100%>
        </td>
        <td colspan="2"><%=bean.getTitle() %></td>
       </tr>
       <tr>
         <th class="text-right" width=15%>개봉</th>
         <td width=55%><%=bean.getRegdate() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>장르</th>
         <td width=55%><%=bean.getGenre() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>등급</th>
         <td width=55%><%=bean.getGrade() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>국가</th>
         <td width=55%><%=bean.getNation() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>시간</th>
         <td width=55%><%=bean.getTime() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>박스오피스</th>
         <td width=55%><%=bean.getBoxoffice() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>누적관객</th>
         <td width=55%><%=bean.getShowUser() %></td>
       </tr>
       
       <tr>
         <th class="text-right" width=15%>평점</th>
         <td width=55%><%=bean.getScore() %></td>
       </tr>
       <tr>
         <td colspan="3">
          <%=bean.getStory() %>
         </td>
       </tr>
       <tr>
         <td colspan="3" class="text-right">
          <a href="list.jsp" class="btn btn-sm btn-danger">목록</a>
         </td>
       </tr>
     </table>
    </div>
  </div>
</body>
</html>






