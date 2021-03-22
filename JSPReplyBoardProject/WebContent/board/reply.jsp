<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // detail.jsp?no=1&page=1
    String no=request.getParameter("no");
    String strPage=request.getParameter("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
   width:800px;
   margin: 0px auto;
}
td{
  font-size: 9pt;
  font-family: 맑은 고딕;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// 글쓰기 버튼을 클릭시에 처리 
	$('.sendBtn').click(function(){
		let name=$('input[name=name]').val(); // value
		//alert(name);
		if(name.trim()=="") 
		{
			$('input[name=name]').focus();
			return;// 밑에 있는 문장은 수행 할 수 없다 = 함수 종료
		}
		
		let subject=$('input[name=subject]').val();
		if(subject.trim()=="")
		{
			$('input[name=subject]').focus();
			return;
		}
		
		let content=$('textarea').val();
		if(content.trim()=="")
		{
			$('textarea').focus();
			return;
		}
		
		let pwd=$('input[name=pwd]').val();
		if(pwd.trim()=="")
		{
			$('input[name=pwd]').focus();
			return;
		}
		
		// 데이터를 전송 
		$('#frm').submit();
		
	})
})
</script>
</head>
<%--
                 no   gi   gs   gt  root  depth
         AAAAA   1    1    0    0     0    1
          =>BBBB 2    1    1    1     1    1
           =>CCCC3    1    2    2     2    0
 --%>
<body>
 <div style="height:30px"></div>
  <div class="container">
   <div class="row">
    <img src="board.png" style="width:800px;height:150px">
    <form method=post action="reply_ok.jsp" id="frm" autocomplete="off">
    <table class="table">
      <tr>
        <th class="text-right danger" width=15%>이름</th>
        <td width=85%>
          <input type=text name=name class="input-sm" size=15>
          <input type=hidden name=pno value="<%=no%>">
          <input type=hidden name=page value="<%=strPage%>">
        </td>
      </tr>
      <tr>
        <th class="text-right danger" width=15%>제목</th>
        <td width=85%>
          <input type=text name=subject class="input-sm" size=55>
        </td>
      </tr>
      <tr>
        <th class="text-right danger" width=15% valign="top">내용</th>
        <td width=85%>
          <textarea rows="10" cols="62" name=content></textarea>
        </td>
      </tr>
      <tr>
        <th class="text-right danger" width=15%>비밀번호</th>
        <td width=85%>
          <input type=password name=pwd class="input-sm" size=15>
        </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <input type="button" value="답변" class="btn btn-sm btn-primary sendBtn">
          <input type="button" value="취소" onclick="javascript:history.back()"
        	  class="btn btn-sm btn-success"
          >
        </td>
      </tr>
    </table>
    </form>
   </div>
  </div>
</body>
</html>
