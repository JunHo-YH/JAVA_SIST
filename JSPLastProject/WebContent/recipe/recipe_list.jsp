<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
          <header class="heading">총 <span style="color:green;font-weight: bold;"><fmt:formatNumber value="${count }" pattern="000,000"/></span>개의 맛있는 레시피가 있습니다.</header>
          <ul class="nospace clear">
          <c:forEach var="vo" items="${rList }" varStatus="s">
            <c:if test="${s.index%4==0 }">
             <li class="one_quarter first"><a href="../recipe/recipe_make.do?no=${vo.no }"><img src="${vo.poster }" title="${vo.title }" class="img-rounded"></a></li>
            </c:if>
            <c:if test="${s.index%4!=0 }">
             <li class="one_quarter"><a href="../recipe/recipe_make.do?no=${vo.no }"><img src="${vo.poster }" title="${vo.title }" class="img-rounded"></a></li>
            </c:if>
          </c:forEach>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <c:if test="${startPage>1 }">
           <li><a href="../recipe/recipe_list.do?page=${startPage-1 }">&laquo; 이전</a></li>
          </c:if>
          <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
            <c:if test="${i==curpage }">
             <c:set var="type" value="class=current"/>
            </c:if>
            <c:if test="${i!=curpage }">
             <c:set var="type" value=""/>
            </c:if>
            <li ${type }><a href="../recipe/recipe_list.do?page=${i }">${i }</a></li>
          </c:forEach>
          <c:if test="${endPage<totalpage }">
            <li><a href="../recipe/recipe_list.do?page=${endPage+1 }">다음 &raquo;</a></li>
          </c:if>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>