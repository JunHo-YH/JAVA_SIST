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
	<div id="app">
	  <h1>{{message}}</h1>
	  <my-component></my-component>
	</div>
	<script>
		Vue.component('my-component',{
			template:'<h1>Hello Component</h1>'
		})
		new Vue({
			el: '#app',
			data:{
				message:'Hello Vue !!'
				senddata:'Component 출력'
			}
		})
	</script>

</body>
</html>