<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/food.css">
<style type="text/css">
.location_row{
  margin: 0px auto;
  width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.images').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	})
	
	$('.images').click(function(){
		let no=$(this).attr("data-value");
		$.ajax({
			type:'post',
			url:'../food/location_result.do',
			data:{"no":no},
			success:function(result)
			{
				$('#print').html(result);
			}
		});
		
	})
});
</script>
</head>
<body>
   <div class="wrapper row3 location_row">
     <div id="a">
      <img id="seoul_1" src="../map/1111.png">
      <c:forEach var="i" begin="1" end="25">
        <img id="gu${i }" src="../map/gu_${i }_off.png"
         onmouseover="this.src='../map/gu_${i }_on.png'"
         onmouseout="this.src='../map/gu_${i }_off.png'"
         class="images" data-value="${i }"
        >
      </c:forEach>
     </div>
   </div>
   <div class="wrapper row3 location_row">
     <div id="print" style="height:500px;overflow-y:auto"></div>
   </div>
</body>
</html>










