<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mypage_row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
<div class="wrapper row3 mypage_row">
  <h2 class="sectiontitle">찜 목록</h2>
  <div style="height: 300px;width:600px;margin:0px auto;overflow-y:auto">
   <table class="table">
    <tr>
     <th></th>
     <th>업체명</th>
     <th>전화번호</th>
     <th>비고</th>
    </tr>
    <c:forEach var="vo" items="${fList }" varStatus="s">
      <tr>
        <td>
          <img src="${vo.poster }" style="width:30px;height: 30px;" class="img-circle">
        </td>
        <td>${vo.title }</td>
        <td>${vo.tel }</td>
        <td>
          <a href="../food/jjim_cancel.do?no=${jList[s.index]}" class="btn btn-sm btn-primary">취소</a>
        </td>
      </tr>
    </c:forEach>
   </table>
  </div>
  <h2 class="sectiontitle">예약 목록</h2>
  <div style="height: 300px;width:600px;margin:0px auto;overflow-y:auto">
    <table class="table">
      <tr>
       <th>예약번호</th>
       <th>업체명</th>
       <th>예약일</th>
       <th>시간</th>
       <th>인원</th>
       <th>상태</th>
      </tr>
      <c:forEach var="vo" items="${rList }">
        <tr>
	       <td>${vo.no }</td>
	       <td>${vo.title }</td>
	       <td>${vo.day }</td>
	       <td>${vo.time }</td>
	       <td>${vo.inwon }</td>
	       <td>${vo.state==0?"예약대기":"예약완료" }</td>
	      </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>










