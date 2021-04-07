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
// Jquery => javascript 라이브러리 
// $(document).ready(function(){}) => window.onload => main
$(function(){
	$('#canBtn').click(function(){
		// 취소버튼 클릭시 처리
		parent.Shadowbox.close();
	});
	$('#logBtn').click(function(){
		//  로그인 버튼 클릭시 처리
		let id=$('#id').val();
		/*
		    val()  <input type=text value=""> 입력한 값,value에 저장된 값 읽기
		    text() <td>값</td>
		    html() <td><span>값</span></td>  ==> <span>값</span>
		    attr() <img src=""> : 속성값 읽기
		    ====================================== getter
		    val("값"),text("")
		*/
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		
		// login을 요청하고 => 결과값을 받아서 처리 
		// login.do (요청) => DispatcherServlet => MemberModel => jsp에 결과값 출력 
		// 요청 => 데이터 전송 방식 (GET,POST)
		// 페이지 변환이 처리가 가능 
		/*
		    {"id":id,"pwd":pwd} => 변환 
		    ../member/login.do?id=admin&pwd=1234
		    		
		    String s="";
		    s.substring()
		*/
		$.ajax({
			type:'POST',
			url:'../member/login.do',
			data:{"id":id,"pwd":pwd},
			success:function(result)
			{
				
				let s=result.trim();
				if(s=="NOID")
				{
					alert("아이디가 존재하지 않습니다!!");
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
				}
				else if(s=="NOPWD")
				{
					alert("비밀번호가 틀립니다!!");
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					// 이동 => main.do로 이동 
					parent.location.href="../main/main.do";
				}
			}
		});
	})
});
</script>
</head>
<body>
  <div style="height:20px"></div>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
       <th width=30% class="text-right danger">ID</th>
       <td width=70%>
         <input type=text name=id size=15 class="input-sm" id=id>
       </td>
      </tr>
      <tr>
       <th width=30% class="text-right danger">Password</th>
       <td width=70%>
         <input type=password name=pwd size=15 class="input-sm" id=pwd>
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <input type="button" value="로그인" class="btn btn-sm btn-success" id="logBtn">
          <input type="button" value="취소" class="btn btn-sm btn-info" id="canBtn">
        </td>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>







