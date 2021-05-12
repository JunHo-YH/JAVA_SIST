<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
   	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="app">
	  <h1>두번째 컴포넌트 만드는 방법</h1>
	  <template id="com">
	    <h1>{{message}}</h1>
	    <h2>컴포넌트</h2>
	    <h2>컴포넌트</h2>
	    <h2>컴포넌트</h2>
	  </template>
	  <my-com></my-com>
	</div>
	
	<script>
	Vue.component('my-com',{
		template:'#com'
	})
	 new Vue({
		 el: '#app',
		 data:{
			 message:'안녕하세요!!'
		 }
	 })
	</script>
</body>
</html>