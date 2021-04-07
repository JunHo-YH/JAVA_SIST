<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.product-card {
  background-color: #fdfefe;
  max-width: 500px;
  min-height: 150px;
  margin: 0 auto;
  margin-top: 20px;
  margin-bottom: 100px;
  box-shadow: 8px 12px 30px #b3b3b3;
  color: #919495;
  font-weight: normal;
  text-align: left;
  font-size: 18px;
  position: relative;
}

.product-details {
  width: 70%;
  float: left;
  height: 100%;
  padding: 30px;
}
.product-details span {
  color: #333;
  margin-bottom: 35px;
}
.product-details button {
  width: 150px;
  height: 50px;
  margin-top: 20px;
  background-color: #337AB7;
  border-radius: 0;
  color: #fff;
  box-shadow: 2px 2px 7px #173853;
}
.product-details button:hover, .product-details button:active, .product-details button:focus {
  color: #fff;
}

.product-image {
  position: absolute;
  right: -10px;
  top: -40px;
}
.product-image img {
  max-width: 150px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('.delBtn').click(function(){
		let no=$(this).attr("data-no");
		let cno=$(this).attr("data-cno");
		location.href="../food/food_reply_delete.do?no="+no+"&cno="+cno;
	});
	
	$('.updateBtn').click(function(){
		$('.updateli').hide();
		$('.updateBtn').text("수정");
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#m'+no).show("slow");
			i=1;
		}
		else
		{
			$(this).text("수정");
			$('#m'+no).hide("slow");
			i=0;
		}
		
	});
});
</script>
</head>
<body>
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
          <c:forTokens var="s" items="${vo.poster }" delims="^">
	        <li>
	          <figure>
	            <img class="radius-10 btmspace-10" src="${s }" alt="">
	          </figure>
	          </a>
	        </li>
	      </c:forTokens>
      </ul>
    </div>
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
    <div class="content two_quarter first"> 
      <!-- ################################################################################################ -->
      <table class="table">
        <tr>
          <td>
            <h3>${vo.title}&nbsp;<span style="color:orange">${ vo.score }</span></h3>
          </td>
        </tr>
      </table>
      <table class="table">
       <tr>
         <th width=20% class="text-right">주소</th>
         <td width=80%>${fn:substring(vo.address,0,fn:indexOf(vo.address,"지"))}</td>
       </tr>
       <tr>
         <th width=20% class="text-right">전화</th>
         <td width=80%>${vo.tel }</td>
       </tr>
       <tr>
         <th width=20% class="text-right">음식 종류</th>
         <td width=80%>${vo.type }</td>
       </tr>
       <tr>
         <th width=20% class="text-right">가격대</th>
         <td width=80%>${vo.price }</td>
       </tr>
       <tr>
         <th width=20% class="text-right">주차</th>
         <td width=80%>${vo.parking}</td>
       </tr>
       <tr>
         <th width=20% class="text-right">영업시간</th>
         <td width=80%>${vo.time }</td>
       </tr>
       
          <c:if test="${vo.menu!='no' }">
      
       <tr>
         <th width=20% class="text-right">메뉴</th>
         <td width=80%>
           <ul style="list-style-type: none">
             <c:forTokens var="s" items="${vo.menu }" delims="원">
               <li>${s }원</li>
             </c:forTokens>
           </ul>
         </td>
       </tr>
       </c:if>
       <tr>
         <td colspan="2" class="text-right">
          <c:if test="${sessionScope.id!=null }">
           <c:if test="${count==0 }">
             <a href="../food/jjim.do?no=${vo.no }" class="btn btn-sm btn-primary">찜하기</a>
           </c:if>
           <c:if test="${count!=0 }">
             <span class="btn btn-sm btn-active">찜하기</span>
           </c:if>
          </c:if>
          <a href="../main/main.do" class="btn btn-sm btn-danger">목록</a>
         </td>
       </tr>
      </table>
      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
      <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['선호도', '댓글'],
          ['좋아요',     <c:out value="${vo.good}"/>],
          ['괜찮다',      <c:out value="${vo.soso}"/>],
          ['별로',  <c:out value="${vo.bad}"/>]
        ]);
        var options = {
          title: '댓글 분석',
          is3D:true
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
      </script>
      <div id="piechart"></div>
      <div id="comments">
        <h2>댓글</h2>
        <ul>
          
          <c:forEach var="rvo" items="${rList }">
	          <li>
	            <article>
	              <header>
	                <figure class="avatar">
	                 <c:if test="${sessionScope.id==rvo.id }">
	                  <span class="btn btn-xs btn-success updateBtn" data-no="${rvo.no }">수정</span>
	                  <span class="btn btn-xs btn-danger delBtn" data-no="${rvo.no }" data-cno="${vo.no }">삭제</span>
	                 </c:if>
	                </figure>
	                <address>
	                By <a href="#">${rvo.name }</a>
	                </address>
	                <time datetime="2045-04-06T08:15+00:00">${rvo.dbday }</time>
	              </header>
	              <div class="comcont">
	                <pre style="white-space: pre-wrap;border:none;background-color:white;">${rvo.msg }</pre>
	              </div>
	            </article>
	          </li>
	          <li style="display:none" id="m${rvo.no }" class="updateli">
	            <form action="../food/food_reply_update.do" method="post">
		          <table class="table">
		            <tr>
		             <td>
		              <textarea rows="7" cols="30" name="msg">${rvo.msg }</textarea>
		              <input type="hidden" name=cno value="${vo.no }">
		              <input type="hidden" name=no value="${rvo.no }">
		              <input type="submit" value="댓글수정" class="btn btn-sm btn-danger">
		             </td>
		            </tr>
		          </table>
		        </form>
	          </li>
          </c:forEach>
        </ul>
        
        <c:if test="${sessionScope.id!=null }">
	        <form action="../food/food_reply_insert.do" method="post">
	          <table class="table">
	            <tr>
	             <td>
	              <textarea rows="7" cols="30" name="msg"></textarea>
	              <input type="hidden" name=cno value="${vo.no }">
	              <input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger">
	             </td>
	            </tr>
	          </table>
	        </form>
        </c:if>
      </div>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- ################################################################################################ -->
    <div class="sidebar two_quarter"> 
      <div id="map" style="width:100%;height:350px;"></div>
      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=db0485ed4f0d0ece879a4510ed7f48e6&libraries=services"></script>
      <script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch("${fn:substring(vo.address,0,fn:indexOf(vo.address,'지'))}", function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.title}</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
		<div style="height:20px"></div>
		<h2 class="sectiontitle">맛집 관련 레시피</h2>
		<%-- 관련 레시피 출력 --%>
		
		 <c:forEach var="rvo" items="${list }">
            <div class="product-card">
			    <div class="product-image">
			    <img src="${rvo.poster }" class="img-circle">
			  </div>
			  <div class="product-details">
			    <span>${rvo.title }</span>
			    <p>${rvo.chef }(조회수:${rvo.hit})</p>
			  </div>
			</div>
         </c:forEach>
       
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>