<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
   	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div style="height: 30px"></div>
	<div class="container-fluid">
	  <div class="col-md-8">
	  	<recipe-template v-bind:recipeData="recipe"></recipe-template>
	  	
	  </div>
	  <div class="col-md-4">
	  
	  </div>
	</div>
	<script>
	 Vue.component('recipe-template',{
		 props:['recipeData'], /* v-bind와 맵핑 */
		 template:'<div class="col-md-4" v-for="vo in recipeData">'
			     + '<div class="thumbnail">'
			     + '<img :src="vo.poster" alt="Lights" style="width:100%">'
			     + '<div class="caption">'
			     + '<p style="font-size: 9px">{{vo.title}}</p>'
			     + '<sub style="font-size:8px">{{vo.chef}}</sub>'
			     + ' </div>'
			  	 + '</div>'
		 
	 })
	 new Vue({
		 el:'.container-fluid',
		 data:{
			 recipe:[],
			 page:1,
			 totalPage:1
		 },
		 mounted:function() {
			 axios.get("http://localhost/web/recipe/list.do").then(response=>{
				 thi.recipe=response.data
			 })
		 }
	 })
	</script>
</body>
</html>