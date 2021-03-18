<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 한글여부 => 디코딩 (숫자 , 알파벳)
    //1.사용자가 보낸 데이터 받기 
    String no=request.getParameter("no");
    //2.오라클 연결 => 데이터 읽기
    MusicDAO dao=new MusicDAO();
    MusicVO vo=dao.musicDetailData(Integer.parseInt(no)); // 각 변수에 맞게 값이 넣어지는건지?
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<!--  어떻게 이게 $('.col-sm-4').html(result); 하면 보여지는지?-->
  <table class="table">
    <tr>
      <td width=30% class="text-center" rowspan="9">
       <img src="<%=vo.getPoster() %>" width=150 height=350>
      </td>
      <td colspan="2">
        <span style="color:orange;font-size: 11pt"><%=vo.getTitle() %></span>
      </td>
    </tr>
    <tr>
      <td width=20% class="text-right">곡 제목</td>
      <td width=50%><%=vo.getTitle() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">가수</td>
      <td width=50%><%=vo.getSinger() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">변동</td>
      <td width=50%><%=vo.getIdcrement() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">앨범</td>
      <td width=50%><%=vo.getAlbum() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">순위</td>
      <td width=50%><%=vo.getIdcrement() %></td>
    </tr>
   
  </table>
</body>
</html>













