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
	  <h2 class="sectiontitle">자료실</h2>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	   <table class="table">
	     <tr>
	      <td>
	       <a href="../databoard/insert.do" class="btn btn-sm btn-danger">등록</a>
	      </td>
	     </tr>
	   </table>
	   <table class="table">
	     <tr>
	      <th class="text-center" width=10%>번호</th>
	      <th class="text-center" width=45%>제목</th>
	      <th class="text-center" width=15%>이름</th>
	      <th class="text-center" width=20%>작성일</th>
	      <th class="text-center" width=10%>조회수</th>
	     </tr>
	     <c:forEach var="vo" items="${list }">
	       <tr>
		      <td class="text-center" width=10%>${vo.no }</td>
		      <td class="text-left" width=45%>
		        <a href="../databoard/detail.do?no=${vo.no }">${vo.subject }</a>
		      </td>
		      <td class="text-center" width=15%>${vo.name }</td>
		      <td class="text-center" width=20%>${vo.regdate }</td>
		      <td class="text-center" width=10%>${vo.hit }</td>
	     </tr>
	     </c:forEach>
	   </table>
	   <table class="table">
	     <tr>
	      <td class="text-center">
	        <a href="#" class="btn btn-sm btn-success">이전</a>
	          ${curpage } page / ${ totalpage} pages
	        <a href="#" class="btn btn-sm btn-info">다음</a>
	      </td>
	     </tr>
	   </table>
	  </div>
	</div>
</body>
</html>






