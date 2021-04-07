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
    <h2 class="sectiontitle">쉐프 목록</h2>
    <div style="height: 600px;width:800px;margin:0px auto;overflow-y:auto">
     <table class="table">
      <tr>
       <td>
         <c:forEach var="vo" items="${list }">
	       <table class="table">
	        <tr>
	          <td width=30% class="text-center" rowspan="2">
	           <a href="../recipe/chef_find.do?chef=${vo.chef_name }">
	           <img src="${vo.poster }" style="width:150px;height:80px" class="img-circle"></a>
	          </td>
	          <td colspan="4" style="color:orange"><a href="../recipe/chef_find.do?chef=${vo.chef_name }">${vo.chef_name }</a></td>
	        </tr>
	        <tr>
	          <td class="text-center"><img src="../images/mc1.png">&nbsp;${vo.mc1 }</td>
	          <td class="text-center"><img src="../images/mc2.png">&nbsp;${vo.mc2 }</td>
	          <td class="text-center"><img src="../images/mc7.png">&nbsp;${vo.mc7 }</td>
	          <td class="text-center"><img src="../images/mc3.png">&nbsp;${vo.mc3 }</td>
	        </tr>
	       </table>
	     </c:forEach>
       </td>
      </tr>
      <tr>
        <td class="text-center">
         <a href="../recipe/chef_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
           ${curpage } page / ${totalpage } pages
         <a href="../recipe/chef_list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">다음</a>
        </td>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>









