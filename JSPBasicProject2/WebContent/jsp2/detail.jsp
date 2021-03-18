<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 한글여부 => 디코딩 (숫자 , 알파벳)
    //1.사용자가 보낸 데이터 받기 
    String mno=request.getParameter("mno");
    //2.오라클 연결 => 데이터 읽기
    MovieDAO dao=new MovieDAO();
    MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
    String s=vo.getStory();
    String temp=vo.getStory();
    if(s.length()>200)
    {
      s=s.substring(0,200)+"...";
      vo.setStory(s);
    }
    String ss=temp;
    if(ss.length()>200)
    {
      ss=ss.substring(200);
      vo.setStory2(ss);
    }
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('.go').css("cursor","pointer");
	$('.go').click(function(){
		/* if(i==0)
		{
			$('.go').text("닫기");
			$('#story').show();
			i=1;
		}
		else
		{
			$('.go').text("더보기");
			$('#story').hide();
			i=0;
		} */
		$('#story').show();
		$('.go').text("");
	});
})
</script>
</head>
<body>
  <table class="table">
    <tr>
      <td>
       <iframe src="http://youtube.com/embed/<%=vo.getKey()%>" width=500 height=300></iframe>
      </td>
    </tr>
  </table>
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
      <td width=20% class="text-right">장르</td>
      <td width=50%><%=vo.getGenre() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">국가</td>
      <td width=50%><%=vo.getNation() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">개봉</td>
      <td width=50%><%=vo.getRegdate() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">등급</td>
      <td width=50%><%=vo.getGrade() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">평점</td>
      <td width=50%><%=vo.getScore() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">박스오피스</td>
      <td width=50%><%=vo.getBoxoffice() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">누적인원</td>
      <td width=50%><%=vo.getShowUser() %></td>
    </tr>
    <tr>
      <td width=20% class="text-right">시간</td>
      <td width=50%><%=vo.getTime() %></td>
    </tr>
    <tr>
      <td colspan="3" height="150" valign="top">
      <%=vo.getStory() %>
      &nbsp;&nbsp;<span class="go" style="color:red">더보기</span>
      <div id="story" style="display:none">
        <%=vo.getStory2() %>
      </div>
      </td>
    </tr>
    
  </table>
</body>
</html>













