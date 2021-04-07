<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   width:500px;
   margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#findBtn').click(function(){
		let dong=$('#dong').val();
		if(dong.trim()=="")
		{
			$('#check').text("동/읍/면을 입력하세요");
			$('#dong').focus();
			return;
		}
		$('#check').text("");
		$.ajax({
			type:'post',
			url:'../member/post_result.do',//post_result.do/dong/값
			data:{"dong":dong},
			success:function(result)
			{
				$('.print').html(result);
			}
		})
		
	})
})
</script>
</head>
<body>
   <div style="height: 20px"></div>
   <div class="container">
     <div class="row">
       <table class="table">
        <tr>
         <td>
         <%--
            posstfind.do?dong=
          --%>
          입력:<input type=text name="dong" size=10 class="input-sm" id="dong">
           <input type=button value="검색" class="btn btn-sm btn-primary" id="findBtn">
         </td>
        </tr>
        <tr>
          <td>
            <span style="color:red" id="check"></span>
          </td>
        </tr>
       </table>
       <div class="print"></div>
     </div>
   </div>
</body>
</html>











