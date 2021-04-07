<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.recomm_row{
  margin: 0px auto;
  width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.main_menu').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'../recommand/recommand_sub.do',
			data:{"no":no},
			success:function(result)
			{
				$('#sub_print').html(result);
			}
		})
	})
})
</script>
</head>
<body>
 <div class="wrapper row3 recomm_row">
  <h2 class="sectiontitle">추천</h2>
  <div class="text-center">
    <c:forEach var="menu" items="${title }" varStatus="s">
      <span class="btn btn-lg btn-primary main_menu" data-no="${s.index+1 }">${menu }</span>
     </c:forEach>
  </div>
  <div class="text-center" id="sub_print">
  
  </div>
  <div class="text-center" id="data_print" style="height:350px">
  
  </div>
 </div>
</body>
</html>






