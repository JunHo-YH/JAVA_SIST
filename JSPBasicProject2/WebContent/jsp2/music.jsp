<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    // 오라클로 부터 출력할 데이터를 읽어 온다 
    MusicDAO dao=new MusicDAO();
    ArrayList<MusicVO> list=dao.musicListData();
    for(MusicVO vo:list)
    {
    	String s=vo.getTitle();
    	if(s.length()>13)
    	{
    		s=s.substring(0,13)+"...";
    	}
    	vo.setTitle(s);
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
   width:100%;
   margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.img').css("cursor","pointer");
	$('.img').click(function(){
		let no=$(this).attr("data");
		// detail.jsp?no=1
		$.ajax({
			type:'POST',
			url:'musicDetail.jsp',      // musicDetail.jsp의 페이지 전체를 '.col-sm-4'위치에 .html(result) 페이지를 보여라 !
			data:{"no":no},
			success:function(result)
			{
				//alert(result);
				$('.col-sm-4').html(result);
			}
		})
	})
});
</script>
</head>
<!-- 
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="panel panel-warning">
      <div class="panel-heading">Panel with panel-warning class</div>
      <div class="panel-body">Panel Content</div>
    </div>
 -->
<body>
   <div style="height: 30px"></div>
   <div class="container-fluid">
    <div class="row">
      <div class="col-sm-8">
       <%
           for(MusicVO vo:list)
           {
       %>
               <div class="col-md-3">
                 <div class="panel panel-primary">
			      <div class="panel-heading"><%=vo.getTitle() %></div>
			      <div class="panel-body">
			        <img src="<%=vo.getPoster() %>" width=100% class="img-rounded img" 
			        data="<%=vo.getNo()%>">
			      </div>
			     </div>
               </div>
                
       <%
           }
       %>
      </div>
      <div class="col-sm-4">
      
      </div>
    </div>
   </div>
</body>
</html>








