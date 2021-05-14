<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <style type="text/css">
  .row {
    margin: 0px auto;
  }
  h3{
    text-align: center
  }
  </style>
</head>
<body>
   <div style="height:30px"></div>
   <div class="container-fluid">
     <div class="row">
	      <div class="col-md-6">
	        <h3>영화 목록</h3>
	        <div id="app1">
	          <table class="table">
	           <tr>
	             <td>
	              <button class="btn btn-sm btn-danger" v-on:click="movieRead()">영화 읽기</button>
	             </td>
	           </tr>
	          </table>
	          <table class="table">
	           <tr>
	            <th>순위</th>
	            <th></th>
	            <th>영화명</th>
	           </tr>
	           <tr v-for="m in movie">
	             <td>{{m.mno}}</td>
	             <td><img :src="m.poster" width=30 height=30></td>
	             <td>{{m.title}}</td>
	           </tr>
	          </table>
	        </div>
	      </div>
	      <div class="col-md-6">
	        <h3>음악목록</h3>
	        <div id="app2">
	        
	        </div>
	      </div>
     </div>   
     <div style="height:20px"></div>
     <div class="row">
	      <div class="col-md-6">
	        <h3>맛집목록</h3>
	        <div id="app3">
	          <table class="table">
	           <tr>
	             <td>
	              <button class="btn btn-sm btn-danger" v-on:click="foodRead()">맛집 읽기</button>
	             </td>
	           </tr>
	          </table>
	          <table class="table">
	           <tr>
	            <th></th>
	            <th>업체명</th>
	            <th>전화</th>
	           </tr>
	           <tr v-for="f in food">
	             <td><img :src="f.poster" width=30 height=30></td>
	             <td>{{f.title}}</td>
	             <td>{{f.tel}}</td>
	           </tr>
	          </table>
	        </div>
	      </div>
	      <div class="col-md-6">
	        <h3>레시피목록</h3>
	        <div id="app4">
	        
	        </div>
	      </div>
     </div>   
   </div>
   <script>
     let app1=new Vue({
    	 el:'#app1',
    	 data:{
    		 movie:[]
    	 },
    	 methods:
    	 {
    		 movieRead:function()
    		 {
    			 let _this=this
    			 axios.get("http://localhost/web/total/movie.do").then(function(response){
        			 _this.movie=response.data
        			 console.log(_this.movie);
        		 })
    		 }
    		 
    	 }
     });
     let app2=new Vue({
    	 el:'#app2',
    	 data:{
    		 music:[]
    	 }
     });
     let app3=new Vue({
    	 el:'#app3',
    	 data:{
    		 food:[]
    	 },
    	 methods:
    	 {
    		 foodRead:function()
    		 {
    			 let _this=this
    			 axios.get("http://localhost/web/total/food.do").then(function(response){
        			 _this.food=response.data
        			 console.log(_this.food);
        		 })
    		 }
    		 
    	 }
     });
     let app4=new Vue({
    	 el:'#app4',
    	 data:{
    		 recipe:[]
    	 }
     })
   </script>
</body>
</html>













