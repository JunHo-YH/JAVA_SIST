<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.join_row{
  width:700px;
  margin: 0px auto;
}
</style>

</head>
<body>
  <div class="wrapper row3 join_row">
  <h2 class="sectiontitle">회원가입</h2>
  <form method=post action="../member/join_ok.do" name="join_frm">
  <table class="table">
    <tr>
     <th width=20% class="text-right">ID</th>
     <td width=80%>
      <input type=text name="id" id="id" class="input-sm" style="float:left" readonly>&nbsp;
      <input type="button" value="중복체크" class="btn btn-sm btn-primary" style="float:left" id="checkBtn">
     </td>
    </tr>
    <tr>
     <th width=20% class="text-right">비밀번호</th>
     <td width=80%>
      <input type=password name="pwd" id="pwd" class="input-sm" style="float:left">
      &nbsp;
      <input type=password name="pwd" id="pwd1" class="input-sm" style="float:left" placeholder="재입력">
     </td>
    </tr>
    <tr>
     <th width=20% class="text-right">이름</th>
     <td width=80%>
      <input type=text name="name" id="name" class="input-sm">
     </td>
    </tr>
    <tr>
     <th width=20% class="text-right">성별</th>
     <td width=80%>
      <ul class="inline">
       <li><input type=radio name="sex" class="input-sm"  checked value="남자">남자</li>
       <li><input type=radio name="sex" class="input-sm"  value="여자">여자</li>
      </ul>
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">생년월일</th>
     <td width=80%>
      <input type=date size="20" name="birthday">
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">이메일</th>
     <td width=80%>
      <input type=text name="email" id="email" class="input-sm" size=45>
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">우편번호</th>
     <td width=80%>
      <input type=text name="post" id="post" class="input-sm" size=10 readonly style="float: left">
      <input type=button value="우편번호검색" class="btn btn-sm btn-danger" id="postBtn" style="float: left">
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">주소</th>
     <td width=80%>
      <input type=text name="addr1" id="addr1" class="input-sm" size=45 readonly>
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">상세주소</th>
     <td width=80%>
      <input type=text name="addr2" id="addr2" class="input-sm" size=45>
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">전화번호</th>
     <td width=80%>
      <input type=text name="tel1" id="tel1" class="input-sm" size=5 readonly value="010"
      style="float: left">
      <input type=text name="tel2" id="tel2" class="input-sm" size=10 style="float: left">
     </td>
    </tr>
    
    <tr>
     <th width=20% class="text-right">소개</th>
     <td width=80%>
      <textarea rows="7" cols="50" name="content"></textarea>
     </td>
    </tr>
    
    <tr>
     <td colspan="2" class="text-center">
      <input type=submit value="회원가입" class="btn btn-sm btn-success">
      <input type=button value="취소" class="btn btn-sm btn-warning"
       onclick="javascript:history.back()"
      >
     </td>
    </tr>
    
  </table>
  </form>
  </div>
</body>
</html>







