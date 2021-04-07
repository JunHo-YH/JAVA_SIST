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
	  <h2 class="sectiontitle">예약 현황</h2>
	  <div style="height: 500px;overflow-y:auto">
	   <table class="table">
	    <tr>
	      <th class="text-center">예약번호</th>
	      <th class="text-center">아이디</th>
	      <th class="text-center">업체명</th>
	      <th class="text-center">예약일</th>
	      <th class="text-center">예약시간</th>
	      <th class="text-center">인원</th>
	      <th class="text-center">등록일</th>
	      <th class="text-center">상태</th>
	    </tr>
	    <c:forEach var="vo" items="${list }">
	      <tr>
	          <td class="text-center">${vo.no }</td>
		      <td class="text-center">${vo.id }</td>
		      <td class="text-left">${vo.title }</td>
		      <td class="text-center">${vo.day }</td>
		      <td class="text-center">${vo.time }</td>
		      <td class="text-center">${vo.inwon }</td>
		      <td class="text-center">${vo.dbday }</td>
		      <td class="text-center">
		        <c:if test="${vo.state==0 }">
		          <a href="../food/reserve_ok.do?no=${vo.no }" class="btn btn-sm btn-danger">승인대기</a>
		        </c:if>
		        <c:if test="${vo.state==1 }">
		          <span class="btn btn-sm btn-active">승인완료</span>
		        </c:if>
		      </td>
	      </tr>
	    </c:forEach>
	   </table>
	  </div>
	</div>
</body>
</html>










