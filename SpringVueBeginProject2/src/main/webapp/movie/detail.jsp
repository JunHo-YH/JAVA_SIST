<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.row {
   margin: 0px auto;
   width:700px;
}
</style>
</head>
<body>
  <%--
     poster,title,regdate,genre,nation,grade,time,story,key;
    private double score;
    
    class A
    new A()
    new A()
   --%>
  <div id="app">
    <div class="row">
      <table class="table">
       <tr>
        <td class="text-center">
          <iframe :src="'http://youtube.com/embed/'+movie.key" width="700" height="350"></iframe>
        </td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <td class="text-center" width=30% rowspan="7">
            <img :src="movie.poster" width=100%>
          </td>
          <td colspan="2"><h3>{{movie.title}}</h3></td>
        </tr>
        <tr>
          <td class="text-right" width=10%>장르</td>
          <td width=60%>{{movie.genre}}</td>
        </tr>
        <tr>
          <td class="text-right" width=10%>등급</td>
          <td width=60%>{{movie.grade}}</td>
        </tr>
        <tr>
          <td class="text-right" width=10%>시간</td>
          <td width=60%>{{movie.time}}</td>
        </tr>
        <tr>
          <td class="text-right" width=10%>국가</td>
          <td width=60%>{{movie.nation}}</td>
        </tr>
        <tr>
          <td class="text-right" width=10%>상영일</td>
          <td width=60%>{{movie.regdate}}</td>
        </tr>
        <tr>
          <td class="text-right" width=10%>평점</td>
          <td width=60%>{{movie.score}}</td>
        </tr>
        <tr>
          <td colspan="3">{{movie.story}}</td>
        </tr>
      </table>
    </div>
    <script>
     new Vue({
    	 el:'#app',
    	 data:{
    		 movie:{},
    		 mno:${mno}
    	 },
    	 mounted:function(){
    		 axios.get("http://localhost/web/movie/movie_detail.do",{
    			 params:{
    				 mno:this.mno
    			 }
    		 }).then(response=>{
    			 this.movie=response.data
    		 })
    	 }
     })
    </script>
  </div>
</body>
</html>













