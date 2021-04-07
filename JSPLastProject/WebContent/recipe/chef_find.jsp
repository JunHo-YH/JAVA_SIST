<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">Lorem</a></li>
      <li><a href="#">Ipsum</a></li>
      <li><a href="#">Dolor</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
         <ul class="nospace clear">
          <c:forEach var="vo" items="${list }" varStatus="s">
            <c:if test="${s.index%4==0 }">
             <li class="one_quarter first"><a href="../recipe/recipe_make.do?no=${vo.no }"><img src="${vo.poster }" title="${vo.title }" class="img-rounded"></a></li>
            </c:if>
            <c:if test="${s.index%4!=0 }">
             <li class="one_quarter"><a href="../recipe/recipe_make.do?no=${vo.no }"><img src="${vo.poster }" title="${vo.title }" class="img-rounded"></a></li>
            </c:if>
          </c:forEach>
          </ul>
        </figure>
      </div>
      <div>
       <div class="text-center">
        <a href="../recipe/chef_find.do?page=${curpage>1?curpage-1:curpage }&chef=${chef}" class="btn btn-sm btn-danger">이전</a>
         ${curpage } page / ${totalpage } pages
        <a href="../recipe/chef_find.do?page=${curpage<totalpage?curpage+1:curpage }&chef=${chef}" class="btn btn-sm btn-danger">다음</a>
       </div>
      </div>
     </div>
     <div class="clear"></div>
    </main>
   </div>
</body>
</html>