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
    <h2 class="sectiontitle">레시피 상세보기</h2>
    <div style="height: 600px;width:800px;margin:0px auto;overflow-y:auto">
     <c:if test="${vo.title==null}">
       <table class="table">
        <tr>
         <td class="text-center">관련데이터가 없습니다</td>
        </tr>
       </table>
     </c:if>
     <c:if test="${vo.title!=null }">
      <table class="table">
       <tr>
         <td class="text-center" colspan="3">
          <img src="${vo.poster }" style="height:300px;width:600px">
         </td>
       </tr>
       <tr>
         <td class="text-center" colspan="3"><h3>${vo.title }</h3></td>
       </tr>
       <tr>
         <td class="text-center" colspan="3">${vo.content }</td>
       </tr>
       <tr>
         <td class="text-center"><img src="../images/info1.png"></td>
         <td class="text-center"><img src="../images/info2.png"></td>
         <td class="text-center"><img src="../images/info3.png"></td>
       </tr>
       <tr>
         <td class="text-center">${vo.info1 }</td>
         <td class="text-center">${vo.info2 }</td>
         <td class="text-center">${vo.info3 }</td>
       </tr>
       <tr>
         <td colspan="3">
           <ul style="list-style-type: none">
             <c:forEach var="s" items="${food }">
              <li>${s }</li>
             </c:forEach>
           </ul>
         </td>
       </tr>
       <tr>
         <td colspan="3" class="text-center">
          <img src="${vo.chef_poster }" style="width:50px;height:50px" class="img-circle">
          <p>${vo.chef }</p>
          <sub>${vo.chef_info }</sub>
         </td>
       </tr>
      </table>
     </c:if>
    </div>
  </div>
</body>
</html>









