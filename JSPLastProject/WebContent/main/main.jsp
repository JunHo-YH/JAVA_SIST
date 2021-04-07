<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Food&Recipe</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../css/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../shadow/css/shadowbox.css">
<!-- <style type="text/css">
.search-container {
  overflow: hidden !important;
  float: right !important;
  height: 4em !important;
  width: 4em !important;
  border-radius: 2em !important;
  box-shadow: 0 0 5px #6A5D4F !important;
  -moz-transition: all 0.35s !important;
  -webkit-transition: all 0.35s !important;
}
.search-container:hover, .search-container:focus, .search-container:focus-within {
  width: 25em !important;
  border-radius: 5px 2em 2em 5px !important;
  outline: none !important;
}
.search-container:hover input, .search-container:focus input, .search-container:focus-within input {
  display: inline-block !important;
  width: 19em !important;
  padding: 10px !important;
}

input {
  -moz-appearance: none !important;
  -webkit-appearance: none !important;
  appearance: none !important;
  float: left !important;
  width: 0em !important;
  height: 2em !important;
  margin: 1em !important;
  margin-right: -4.5em !important;
  background: #fff !important;
  color: #6A5D4F !important;
  font-size: 1em !important;
  font-weight: 600 !important;
  padding: 0px !important;
  border: 0 !important;
  border-radius: 5px !important;
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.2) inset !important;
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.15) !important;
  -moz-transition: all 0.25s !important;
  -webkit-transition: all 0.25s !important;
}
input:focus {
  outline: none !important;
  box-shadow: 0 -1px 1px rgba(255, 255, 255, 0.25), 0 1px 5px rgba(0, 0, 0, 0.15) !important;
}

.button {
  float: right !important;
  width: 1.75em !important;
  height: 1.75em !important;
  margin: 0.125em !important;
  background: #6A5D4F !important;
  text-align: center !important;
  font-size: 2em !important;
  color: #FDF6E3 !important;
  border-radius: 50% !important;
  box-shadow: 0 -1px 1px rgba(255, 255, 255, 0.25), 0 1px 1px rgba(0, 0, 0, 0.25) !important;
  text-shadow: 0 -2px 1px rgba(0, 0, 0, 0.3) !important;
}
.button i {
  margin-top: 0.3em !important;
}
.button:active {
  border: 0 !important !important;
  text-shadow: 0 0 0 !important;
}
</style> -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../shadow/js/shadowbox.js"></script>
<script type="text/javascript">
Shadowbox.init({
	players:["iframe"]
});
$(function(){
	$('#login').click(function(){
		Shadowbox.open({
			content:'../member/login.jsp',
			player:'iframe',
			title:'로그인',
			width:340,
			height:200
		})
	})
	$('#postBtn').click(function(){
		/*Shadowbox.open({
			content:'../member/postfind.jsp',
			player:'iframe',
			title:'우편번호검색',
			width:540,
			height:450
		})*/
		new daum.Postcode({
			oncomplete:function(data)
			{
				$('#post').val(data.zonecode);
				$('#addr1').val(data.address);
			}
		}).open();
	})
	$('#checkBtn').click(function(){
		Shadowbox.open({
			content:'../member/idcheck.jsp',
			player:'iframe',
			title:'아이디중복체크',
			width:340,
			height:200
		})
	})
});
</script>
<style type="text/css">
.food_row{
   width:960px;
   margin: 0px auto;
}
</style>
</head>
<body id="top">
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">맛집 & 레시피</a></h1>
    </div>
    <div class="fl_right">
      <!-- <ul class="inline">
        <li>ID:<input type=text name=id class="input-xs" size=10></li>
        <li>Password:<input type=password name=pwd class="input-xs" size=10></li>
        <li><span class="btn btn-sm btn-primary">로그인</span></li>
      </ul>-->
      <div class='search-container' tabindex='1'>
        <input placeholder='search' type='text'>
        <a class='button'>
          <i class='icon-search'></i>
        </a>
      </div>
    </div>
    <!-- ################################################################################################ --> 
  </header>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      
      <c:if test="${sessionScope.id==null }">
        <li><a href="#" id="login">로그인</a></li>
      </c:if>
      <c:if test="${sessionScope.id!=null }">
        <li><a href="../member/logout.do">로그아웃</a></li>
      </c:if>
      
      
      <c:if test="${sessionScope.id==null }">
	      <li><a class="drop" href="#">회원가입</a>
	        <ul>
	          <li><a href="../member/join.do">회원가입</a></li>
	          <li><a href="pages/full-width.html">아이디찾기</a></li>
	          <li><a href="pages/sidebar-left.html">비밀번호찾기</a></li>
	        </ul>
	      </li>
      </c:if>
      <c:if test="${sessionScope.id!=null }">
	      <li><a class="drop" href="#">회원수정</a>
	        <ul>
	          <li><a href="pages/gallery.html">회원수정</a></li>
	          <li><a href="pages/full-width.html">비밀번호변경</a></li>
	          <li><a href="pages/sidebar-left.html">회원탈퇴</a></li>
	        </ul>
	      </li>
      </c:if>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/location.do">지역별맛집</a></li>
          <c:if test="${sessionScope.id!=null }">
	          <li><a href="../recommand/recommand.do">맛집추천</a></li>
	          <li><a href="../food/reserve.do">맛집예약</a></li>
          </c:if>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="../recipe/recipe_list.do">레시피</a></li>
          <li><a href="../recipe/chef_list.do">쉐프</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="#">자유게시판</a></li>
          <li><a href="#">묻고답하기</a></li>
          <li><a href="../databoard/list.do">자료실</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">뉴스</a>
        <ul>
          <li><a href="#">맛집뉴스</a></li>
          <li><a href="#">레시피뉴스</a></li>
          <li><a href="#">전체뉴스</a></li>
        </ul>
      </li>
       <c:if test="${sessionScope.id!=null }">
         <c:if test="${sessionScope.admin=='n' }">
          <li><a href="../food/mypage.do">마이페이지</a></li>
         </c:if>
         
         <c:if test="${sessionScope.admin=='y' }">
          <li><a href="../food/adminpage.do">관리자페이지</a></li>
         </c:if>
       </c:if>
    </ul>
    <!-- ################################################################################################ --> 
  </nav>
  
</div>
  <%--
      ${sessionScope.id!=null } => session에 저장 (로그인 처리 완료)
      session.setAttribute("id",id) : 저장
      session.getAttribute("id") : 저장된 값 읽기
      => EL => ${sessionScope.id}
   --%>
  <c:if test="${sessionScope.id!=null }">
	<div class="wrapper food_row">
	  <div class="text-right">${sessionScope.name}(${sessionScope.admin=='y'?"관리자":"일반사용자" })님 로그인중입니다</div>
	</div>
  </c:if>
<!-- 내용이 들어가는 위치 -->
   <jsp:include page="${main_jsp }"></jsp:include>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->

<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
     <p class="text-center">
       강북쌍용교육센터 G강의장
     </p>
    <!-- ################################################################################################ --> 
  </footer>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<!-- <div class="wrapper row5">
  <div id="copyright" class="clear"> 
    ################################################################################################
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    ################################################################################################ 
  </div>
</div> -->

<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../js/jquery.min.js"></script> 
<script src="../js/jquery.backtotop.js"></script> 
<script src="../js/jquery.mobilemenu.js"></script> 
<script src="../js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=db0485ed4f0d0ece879a4510ed7f48e6&libraries=services"></script>
</body>
</html>