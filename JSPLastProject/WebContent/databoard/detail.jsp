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
	  <h2 class="sectiontitle">내용보기</h2>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	    <table class="table">
	     <tr>
	      <th width=20% class="text-center">번호</th>
	      <td width=30% class="text-center">${vo.no }</td>
	      <th width=20% class="text-center">작성일</th>
	      <td width=30% class="text-center">${vo.regdate }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">이름</th>
	      <td width=30% class="text-center">${vo.name }</td>
	      <th width=20% class="text-center">조회수</th>
	      <td width=30% class="text-center">${vo.hit }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">제목</th>
	      <td colspan="3">${vo.subject }</td>
	     </tr>
	     <c:if test="${vo.filesize>0 }">
		     <tr>
		      <th width=20% class="text-center">첨부파일</th>
		      <td colspan="3"><a href="../databoard/download.do?fn=${vo.filename }">${vo.filename }</a>(${vo.filesize }Bytes)</td>
		     </tr>
	     </c:if>
	     <tr>
	      <td colspan="4" class="text-left" valign="top" height="200">
	      <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
	      </td>
	     </tr>
	     <tr>
	       <td class="text-right" colspan="4">
	        <ul class="inline">
		        <a href="#" class="btn btn-sm btn-success">수정</a>
		        <a href="#" class="btn btn-sm btn-info">삭제</a>
		        <a href="../databoard/list.do" class="btn btn-sm btn-warning">목록</a>
	        </ul>
	       </td>
	     </tr>
	    </table>
	  </div>
	</div>
</body>
</html>










