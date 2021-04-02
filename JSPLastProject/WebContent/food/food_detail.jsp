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
      </table>
      <div id="comments">
        <h2>Comments</h2>
        <ul>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="../images/demo/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="../images/demo/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
          <li>
            <article>
              <header>
                <figure class="avatar"><img src="../images/demo/avatar.png" alt=""></figure>
                <address>
                By <a href="#">A Name</a>
                </address>
                <time datetime="2045-04-06T08:15+00:00">Friday, 6<sup>th</sup> April 2045 @08:15:00</time>
              </header>
              <div class="comcont">
                <p>This is an example of a comment made on a post. You can either edit the comment, delete the comment or reply to the comment. Use this as a place to respond to the post or to share what you are thinking.</p>
              </div>
            </article>
          </li>
        </ul>
        <h2>Write A Comment</h2>
        <form action="#" method="post">
          <div class="one_third first">
            <label for="name">Name <span>*</span></label>
            <input type="text" name="name" id="name" value="" size="22">
          </div>
          <div class="one_third">
            <label for="email">Mail <span>*</span></label>
            <input type="text" name="email" id="email" value="" size="22">
          </div>
          <div class="one_third">
            <label for="url">Website</label>
            <input type="text" name="url" id="url" value="" size="22">
          </div>
          <div class="block clear">
            <label for="comment">Your Comment</label>
            <textarea name="comment" id="comment" cols="25" rows="10"></textarea>
          </div>
          <div>
            <input name="submit" type="submit" value="Submit Form">
            &nbsp;
            <input name="reset" type="reset" value="Reset Form">
          </div>
        </form>
      </div>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- ################################################################################################ -->
    <div class="sidebar two_quarter"> 
      <div id="map" style="width:100%;height:350px;"></div>
      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf8b694af5fe5a15b76f628730556e5d&libraries=services"></script>
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