<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Food&Recipe</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../css/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
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
      <h1><a href="index.html">맛집 & 레시피</a></h1>
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
      <li class="active"><a href="index.html">Home</a></li>
      <li><a class="drop" href="#">회원가입</a>
        <ul>
          <li><a href="pages/gallery.html">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호찾기</a></li>
        </ul>
      </li>
      <!--<li><a class="drop" href="#">회원수정</a>
        <ul>
          <li><a href="pages/gallery.html">회원수정</a></li>
          <li><a href="pages/full-width.html">비밀번호변경</a></li>
          <li><a href="pages/sidebar-left.html">회원탈퇴</a></li>
        </ul>
      </li>-->
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="#">지역별맛집</a></li>
          <li><a href="#">맛집추천</a></li>
          <li><a href="#">맛집예약</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="#">레시피</a></li>
          <li><a href="#">쉐프</a></li>
          <li><a href="#">오늘의 레시피</a></li>
          <li><a href="#">오늘의 쉐프</a></li>
          <li><a href="#">인기 레시피</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="#">자유게시판</a></li>
          <li><a href="#">묻고답하기</a></li>
          <li><a href="#">후기게시판</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">뉴스</a>
        <ul>
          <li><a href="#">맛집뉴스</a></li>
          <li><a href="#">레시피뉴스</a></li>
          <li><a href="#">전체뉴스</a></li>
        </ul>
      </li>
      <li><a href="#">마이페이지</a></li>
      <!-- <li><a href="#">관리자페이지</a></li>-->
    </ul>
    <!-- ################################################################################################ --> 
  </nav>
  
</div>

<!-- 내용이 들어가는 위치 -->
   <jsp:include page="home.jsp"></jsp:include>
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
</body>
</html>