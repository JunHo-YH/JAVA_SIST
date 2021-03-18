<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    // 오라클로 부터 출력할 데이터를 읽어 온다 
    MovieDAO dao=new MovieDAO();
    ArrayList<MovieVO> list=dao.movieListData();
    for(MovieVO vo:list)
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
		let mno=$(this).attr("data");
		// detail.jsp?mno=1&id=admin
		$.ajax({
			type:'POST',
			url:'detail.jsp',
			data:{"mno":mno},
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
           for(MovieVO vo:list)
           {
       %>
               <div class="col-md-3">
                 <div class="panel panel-primary">
			      <div class="panel-heading"><%=vo.getTitle() %></div>
			      <div class="panel-body">
			        <img src="<%=vo.getPoster() %>" width=100% class="img-rounded img" 
			        data="<%=vo.getMno()%>">
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








