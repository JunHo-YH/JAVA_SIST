<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
<style type="text/css">
.food_row{
   width:960px;
   margin: 0px auto;
}
</style>
</head>
<body>
  <div class="wrapper row3 food_row">
    <table class="table">
      <tr>
       <td class="text-center">
         <h1>${vo.title }</h1>
         <h5>${vo.subject }</h5>
       </td>
      </tr>
    </table>
    <c:forEach var="fvo" items="${list }">
     <!-- <div class="fond"> <span class="s1">blog </span><span class="s2">card</span></div> -->
		<div class="card">
		  <div class="thumbnail"><img class="left" src="${fvo.poster}"/></div>
		  <div class="right">
		    <h1>${fvo.title }&nbsp;<span style="color:orange">${fvo.score }</span></h1>
		    <div class="author">
		      <h2>${fn:substring(fvo.address,0,fn:indexOf(fvo.address,"지"))}</h2>
		    </div>
		    <div class="separator"></div>
		    <p>사장님께서 들어가자마자 친절하게 맞이해주시고, 메뉴에 대한 설명도 자세히 해주셨어요. 최근 비건 디저트가 추가되었다고해서, 저는 쑥머핀과 단호박케이크(둘다 비건메뉴), 아메리카노를 주문했습니다! 일단 플레이팅부터 머랭에, 비건 비스코티 등으로 장식되어있는데, 너무나도 정성스럽고 예뻐서 감탄했고,아메리카노도 꽤 큰컵에 담겨 나왔습니다! 선택장애가 올지도 모를정도로 비건 디저트말고도 정말정말 다양한 메뉴가 있어서, 자주 가게 될것같은곳!!!:-)</p>
		  </div>
		  
		  <div class="fab"><a href="../food/detail_before.do?no=${fvo.no }"><i class="fa fa-arrow-down fa-3x"></i></a></div>
		</div>
      <%--<table class="table">
        <tr>
          <td width=30% class="text-center" rowspan="3">
            <a href="#"><img src="${fvo.poster }" style="width:280px;height:160px"></a>
          </td>
          <td width=70%>
            <h2><a href="#">${fvo.title }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h2>
          </td>
        </tr>
        <tr>
          <td width=70%><span style="color:gray">${fn:substring(fvo.address,0,fn:indexOf(fvo.address,"지"))}</span></td>
        </tr>
        <tr>
          <td width=70%  height="35"></td>
        </tr>
      </table>--%>
    </c:forEach>
  </div>
</body>
</html>















