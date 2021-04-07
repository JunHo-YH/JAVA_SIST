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
   width:300px;
   margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()=="")
		{
			$('#result').text("아이디 입력하세요");
			$('#id').focus();
			return;
		}
		$('#result').text("");
		$.ajax({
			type:'post',
			url:'../member/idcheck_result.do',
			data:{"id":id},
			success:function(result)
			{
				let count=result.trim();
				if(count==0)
				{
					$('#result').html('<font color="blue">'+id+"는(은) 사용 가능합니다"+'</font>');
					$('#check').html('<input type=button value=확인 class="btn btn-sm btn-success" onclick="ok()">')
				}
				else
				{
					$('#result').html('<font color="red">'+id+"는(은) 이미 사용중입니다"+'</font>');
					$('#check').html('');
				}
			}
		});
	})
})
function ok()
{
	parent.join_frm.id.value=$('#id').val();
	parent.Shadowbox.close();
}
</script>
</head>
<body>
   <div style="height: 20px"></div>
   <div class="container">
     <div class="row">
      <table class="table">
        <tr>
          <td>
           ID:<input type=text name=id id=id size=15 class="input-sm">
           <input type="button" id=logBtn value="아이디체크" class="btn btn-sm btn-primary">
          </td>
        </tr>
        <tr>
          <td class="text-center"><span id="result"></span></td>
        </tr>
        <tr>
          <td class="text-center" id="check">
            
          </td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>











